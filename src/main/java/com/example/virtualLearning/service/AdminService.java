package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.*;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.*;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.AdsTable;
import com.example.virtualLearning.tables.CoursesSubcategoryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final CourseRepository courseRepository;

    private final CategoryRepository categoryRepository;

    private final SubcategoryRepository subcategoryRepository;

    private final ChapterRepository chapterRepository;

    private final ContentRepository contentRepository;

    private final InstructorRepository instructorRepository;

    private final QuestionAndAnswersRepository questionAndAnswersRepository;

    private final ChapterTestRepository chapterTestRepository;

    private final OutcomeRepository outcomeRepository;

    private final BenefitsRepository benefitsRepository;

    private final AdsRepository adsRepository;

    private final CourseSubcategoryRepository courseSubcategoryRepository;

    public void insertCourse(Course course)
    {
        if(!categoryRepository.findById(course.getCategoryId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        if(!instructorRepository.findById(course.getInstructorId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_INSTRUCTOR_ID);
        }
        courseRepository.save(course.toCourseTable());
    }

    public void insertCategory(Category category)
    {
        categoryRepository.save(category.toCategoryTable());
    }

    public void insertSub(Subcategory subcategory)
    {
        if(!categoryRepository.findById(subcategory.getCategoryId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CATEGORY_ID);
        }
        subcategoryRepository.save(subcategory.toSubcategoryTable());
    }

    public void insertChapter(Chapter chapter)
    {
        if(!courseRepository.findById(chapter.getCourseId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        chapterRepository.save(chapter.toChapterTable());
    }

    public void insertContent(Content content)
    {
        if(!chapterRepository.findById(content.getChapterId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        contentRepository.save(content.toContentTable());
    }

    public void insertInstructor(Instructor instructor)
    {
        instructorRepository.save(instructor.toInstructorTable());
    }

    public void insertQNA(QuestionAndAnswers questionAndAnswers)
    {
        if(!chapterTestRepository.findById(questionAndAnswers.getChapterTestId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_TEST_ID);
        }
        questionAndAnswersRepository.save(questionAndAnswers.questionAndAnswersTable());
    }

    public void insertChapterTest(ChapterTest chapterTest)
    {
        if(!chapterRepository.findById(chapterTest.getChapterId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        chapterTestRepository.save(chapterTest.toChapterTestTable());
    }

    public void insertOutcome(Outcomes outcomes)
    {
        if(!courseRepository.findById(outcomes.getCourseId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        outcomeRepository.save(outcomes.toOutcomesTable());
    }

    public void insertBenefits(Benefits benefits)
    {
        if(!courseRepository.findById(benefits.getCourseId()).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        benefitsRepository.save(benefits.toBenefitTable());
    }

    public void insertCourseSub(long courseId,long subcategoryId)
    {
        if(!courseRepository.findById(courseId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if(!subcategoryRepository.findById(subcategoryId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_SUBCATEGORY_ID);
        }
        courseSubcategoryRepository.save(new CoursesSubcategoryTable(courseId,subcategoryId));
    }

    public void insertAds(long courseId)
    {
        if(!courseRepository.findById(courseId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        adsRepository.save(new AdsTable(courseId));
    }
}
