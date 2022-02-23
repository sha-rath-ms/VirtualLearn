package com.example.virtualLearning.security;

import com.example.virtualLearning.repository.BlockListRepository;
import com.example.virtualLearning.tables.BlockListTable;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtility implements Serializable {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    @Value("${jwt.secret}")
    private String secretKey;
    @Autowired
    private BlockListRepository blockListRepository;


    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    //Retrive userId by removing bearer word in authorization header
    public String getUserId(String token) {
        return getClaimFromToken(token.substring(7), Claims::getSubject);
    }


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }


    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        log.info(token);
        boolean blocked = blockListRepository.existsById(token);
       clearTokens();
        return expiration.before(new Date())||blocked;
    }

    //Clear blocked tokens
    private void clearTokens(){
        List<BlockListTable> blockedTokens=blockListRepository.findAll();

        for (BlockListTable blockedToken : blockedTokens) {
            String token = blockedToken.getToken();
            Date expiry = getExpirationDateFromToken(token);
            if (expiry.before(new Date())) {
                blockListRepository.deleteById(token);

            }

        }
    }


    //generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return doGenerateToken(claims, userDetails.getUsername());
    }


    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }

    public Boolean isBlocked(String token){
        Boolean blocked = false;
        log.info(String.valueOf(blocked));
        return blocked;
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && !isBlocked(token));
    }

}
