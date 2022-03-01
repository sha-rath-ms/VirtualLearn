package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Chapter;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.response.ResponseChapterContent;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.ChapterTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    private final ContentService contentService;

    private final ChapterTestService chapterTestService;

    private final CourseRepository courseRepository;

    private final MyCourseService myCourseService;

    private List<Chapter> chapterList;

    public List<Chapter> getAllByCourse(long courseId) {
        if(!courseRepository.findById(courseId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        chapterList=chapterRepository.getAll(courseId).stream().map(ChapterTable::toChapter).collect(Collectors.toList());
        chapterList.sort(Comparator.comparing(Chapter::getName));
        return chapterList;
    }

    public ResponseChapterContent getChapterContent(long userId,long courseId,long chapterId) {
        if(!myCourseService.checkIfCourseExists(userId, courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.NOT_JOINED);
        }
        if (!chapterRepository.findById(chapterId).isPresent()) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        return new ResponseChapterContent(contentService.getByChapter(chapterId), chapterTestService.getByChapter(chapterId));
    }
}
