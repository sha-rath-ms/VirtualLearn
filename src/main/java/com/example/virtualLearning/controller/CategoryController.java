package com.example.virtualLearning.controller;


import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.entity.Subcategory;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virtual-learn/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Category> getAll() {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, categoryService.getAll());
    }

    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Category> displayCategoriesAtHomePage(@RequestParam(defaultValue = "0") Integer pageNo) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, categoryService.displayCategoriesAtHomePage(pageNo));
    }

    @GetMapping("/featured/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseAllCourse> getFeaturedCourses(@PathVariable long categoryId)
    {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,categoryService.getFeaturedCourses(categoryId));
    }

    @GetMapping("/beginner/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseAllCourse> getBeginnerCourses(@PathVariable long categoryId)
    {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,categoryService.getBeginnerCourses(categoryId));
    }

    @GetMapping("/subcategory/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Subcategory> getSubcategoryList(@PathVariable long categoryId)
    {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,categoryService.getSubcategoryList(categoryId));
    }

    @GetMapping("/subcategory/all/{subcategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseAllCourse> getBySubcategory(@PathVariable long subcategoryId)
    {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,categoryService.getBySubcategory(subcategoryId));
    }
}
