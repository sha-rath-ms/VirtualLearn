package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Instructor;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.BenefitsRepository;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.repository.InstructorRepository;
import com.example.virtualLearning.repository.OutcomeRepository;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResponseCourseDetails;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private static final int PAGE_LIMIT = 5;

    private final CourseRepository courseRepository;

    private final BenefitsRepository benefitsRepository;

    private final OutcomeRepository outcomeRepository;

    private final InstructorRepository instructorRepository;

    public List<ResponseAllCourse> getAll(int pageNo, long categoryId) {
        Pageable paging = (Pageable) PageRequest.of(pageNo, PAGE_LIMIT);
        Page<CourseTable> pagedResult = courseRepository.getAllCourseByCategoryId(categoryId, paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

    public ResponseCourseDetails getById(long courseId) {
        Optional<CourseTable> courseTable = courseRepository.getById(courseId);
        List<String> benefits = benefitsRepository.getAll(courseId);
        List<String> outcomes = outcomeRepository.getAll(courseId);
        Instructor instructor = instructorRepository.findById(courseTable.get().getInstructorId()).get().toInstructor();
        if (!courseTable.isPresent()) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_ID);
        }
        return new ResponseCourseDetails(courseTable.get(), benefits, outcomes, instructor);
    }
}
