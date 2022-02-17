package com.example.virtualLearning.service;

import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsService {
    private static final int pageLimit = 5;
    private final CourseRepository courseRepository;

    public List<ResponseAllCourse> getAllAds(int pageNo) {
        Pageable paging = PageRequest.of(pageNo, pageLimit);
        Page<CourseTable> pagedResult = courseRepository.findAll(paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }
}
