package com.example.virtualLearning.service;

import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsService {
    private static final int pageLimit = 5;
    private final CourseRepository courseRepository;

    public List<CourseTable> getAllAds(int pageNo) {
        Pageable paging = PageRequest.of(pageNo, pageLimit);
        Page<CourseTable> pagedResult = courseRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        return Collections.emptyList();
    }

    public CourseTable getAdsById(long id) {
        CourseTable courseTable = courseRepository.getById(id);
        if (courseTable == null) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_ID);
        }
        return courseTable;
    }


}
