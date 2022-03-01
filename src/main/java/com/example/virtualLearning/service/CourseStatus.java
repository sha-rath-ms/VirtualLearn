package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Chapter;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.*;
import com.example.virtualLearning.response.ResultInfoConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseStatus {

    private final MyCourseService myCourseService;
    private final CourseRepository courseRepository;
    private final ChapterRepository chapterRepository;
    private final ChapterTestRepository chapterTestRepository;
    private final ContentRepository contentRepository;
    private final VideoStatusRepository videoStatusRepository;
    private final ResultRepository resultRepository;

    private List<Chapter> chapterList;
    private List<Integer> chapterTestId;

    public void completedOrNOt(long userId, long courseId, long chapterId) {
        if (!myCourseService.checkIfCourseExists(userId, courseId)) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if (!courseRepository.existsById(courseId)) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if (!chapterRepository.existsById(chapterId)) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        if (videoStatusRepository.getCompleted(userId, courseId, chapterId) == contentRepository.getCountOfContents(courseId) && chapterTestRepository.getCountOfChapter(courseId) == resultRepository.getCountOfPassResult(userId, courseId)) {
            myCourseService.updateCompleted(courseId, userId);
        }
    }

}
