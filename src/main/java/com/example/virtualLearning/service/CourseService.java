package com.example.virtualLearning.service;

import com.example.virtualLearning.constants.Constants;
import com.example.virtualLearning.entity.Instructor;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.*;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResponseCourseDetails;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.virtualLearning.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class CourseService {



    private final CourseRepository courseRepository;

    private final BenefitsRepository benefitsRepository;

    private final OutcomeRepository outcomeRepository;

    private final CategoryRepository categoryRepository;

    private final InstructorRepository instructorRepository;

    public List<ResponseAllCourse> getAllByCategory(int pageNo, long categoryId) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        Pageable paging = (Pageable) PageRequest.of(pageNo, pageLimit);
        Page<CourseTable> pagedResult = courseRepository.getAllCourseByCategoryId(categoryId, paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

    public List<ResponseAllCourse> getAll(int pageNo)
    {
        Pageable paging = (Pageable) PageRequest.of(pageNo, pageLimit);
        Page<CourseTable> pagedResult = courseRepository.findAll(paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

    public ResponseCourseDetails getById(long courseId) {
        Optional<CourseTable> courseTable = courseRepository.getById(courseId);
        if (!courseTable.isPresent()) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_ID);
        }
        List<String> benefits = benefitsRepository.getAll(courseId);
        List<String> outcomes = outcomeRepository.getAll(courseId);
        Instructor instructor = instructorRepository.findById(courseTable.get().getInstructorId()).get().toInstructor();
        return new ResponseCourseDetails(courseTable.get(), benefits, outcomes, instructor);
    }

    public List<ResponseAllCourse> search(String courseName, Long categoryId, int pageNo) {
        Pageable paging = PageRequest.of(pageNo,pageLimit);
        Page<CourseTable> pagedResult;
        if(categoryId != null) {
           pagedResult = courseRepository.searchInCategory(courseName, categoryId, paging);
        }
        else
        {
            pagedResult = courseRepository.search(courseName, paging);
        }
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }
}
