package com.example.virtualLearning.security;

import com.example.virtualLearning.repository.BlockListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockedCheck {
    private final BlockListRepository blockListRepository;

}
