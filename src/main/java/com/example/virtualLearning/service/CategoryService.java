package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.entity.Course;
import com.example.virtualLearning.entity.Subcategory;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.CategoryRepository;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.repository.SubcategoryRepository;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.CategoryTable;
import com.example.virtualLearning.tables.CourseTable;
import com.example.virtualLearning.tables.SubcategoryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final int PAGE_LIMIT = 5;

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;
    private final SubcategoryRepository subCategoryRepository;


    public List<Category> getAll() {
        return categoryRepository.findAll().stream().map(CategoryTable::toCategory).collect(Collectors.toList());
    }

    public List<Category> displayCategoriesAtHomePage(int pageNo) {
        Pageable paging = (Pageable) PageRequest.of(pageNo, PAGE_LIMIT);
        Page<CategoryTable> pagedResult = categoryRepository.findAll(paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CategoryTable::toCategory).collect(Collectors.toList());
    }

    //Inside category operations from here
    public List<ResponseAllCourse> getFeaturedCourses(Long categoryId) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        return courseRepository.getFeaturedCourses(categoryId).stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());

    }

    public List<ResponseAllCourse> getBeginnerCourses(Long categoryId) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        return courseRepository.getBeginnerCourses(categoryId).stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

    public List<Subcategory> getSubcategoryList(Long categoryId) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        return subCategoryRepository.findByCategoryId(categoryId).stream().map(SubcategoryTable::toSubcategory).collect(Collectors.toList());
    }

    public List<ResponseAllCourse> getAllCourses(int pageNo,Long categoryId) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        return courseRepository.getAllCourseByCategoryId(categoryId, PageRequest.of(pageNo, PAGE_LIMIT)).toList().stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

    public List<ResponseAllCourse> getAllCourses(Long categoryId, Integer page) {
        if(!categoryRepository.findById(categoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        return courseRepository.getAllCourseByCategoryId(categoryId, PageRequest.of(page, PAGE_LIMIT)).stream().map(CourseTable::responseAllCourse).collect(Collectors.toList());
    }

}