package com.example.virtualLearning.response;

import com.example.virtualLearning.entity.Instructor;
import com.example.virtualLearning.tables.CourseTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseCourseDetails {
    private long id;
    private String name;
    private String imageUrl;
    private String overview;
    private Instructor instructor;
    private List<String> benefitMessages;
    private List<String> outcomeMessages;

    public ResponseCourseDetails(CourseTable courseTable, List<String> benefitMessages, List<String> outcomeMessages, Instructor instructor) {
        this.id = courseTable.getId();
        this.name = courseTable.getName();
        this.imageUrl = courseTable.getImageUrl();
        this.overview = courseTable.getOverview();
        this.benefitMessages = benefitMessages;
        this.outcomeMessages = outcomeMessages;
        this.instructor = instructor;
    }
}
