package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.AdsService;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virtual-learn")
@Slf4j
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;

    @GetMapping("/ads/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<CourseTable>> getAll(@RequestParam(defaultValue = "0") int pageNo) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, adsService.getAllAds(pageNo));
    }

    @GetMapping("/ads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<CourseTable> getAdsById(@PathVariable long id) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, adsService.getAdsById(id));
    }
}
