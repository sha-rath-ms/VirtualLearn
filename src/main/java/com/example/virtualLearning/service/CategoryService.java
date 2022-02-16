package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.repository.CategoryRepository;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.repository.SubcategoryRepository;
import com.example.virtualLearning.tables.CategoryTable;
import com.example.virtualLearning.tables.CourseTable;
import com.example.virtualLearning.tables.SubcategoryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
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


    public List<Category> getAll()
    {
        return categoryRepository.findAll().stream().map(CategoryTable::toCategory).collect(Collectors.toList());
    }

    public List<Category> displayCategoriesAtHomePage(int pageNo)
    {
        Pageable paging = (Pageable) PageRequest.of(pageNo, PAGE_LIMIT);
        Page<CategoryTable> pagedResult = categoryRepository.findAll(paging);
        if (!pagedResult.hasContent()) {
            return Collections.emptyList();
        }
        return pagedResult.getContent().stream().map(CategoryTable::toCategory).collect(Collectors.toList());
    }

    //Inside category operations from here
    public List<CourseTable> getFeaturedCourses(Long categoryId){
        return courseRepository.getFeaturedCourses(categoryId);

    }
    public List<CourseTable> getBeginnerCourses(Long categoryId){
        return courseRepository.getBeginnerCourses(categoryId);
    }
    public List<SubcategoryTable> getSubcategoryList(Long categoryId){
        return subCategoryRepository.findByCategoryId(categoryId);
    }
    //Overloaded method
    public List<CourseTable> getAllCourses(Long categoryId){
        return courseRepository.getAllCourseByCategoryId(categoryId,PageRequest.of(0,10)).toList();
    }
    public List<CourseTable> getAllCourses(Long categoryId, Integer page){
        return courseRepository.getAllCourseByCategoryId(categoryId,PageRequest.of(page,10)).toList();
    }

}
