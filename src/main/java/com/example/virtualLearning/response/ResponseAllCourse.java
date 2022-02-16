package com.example.virtualLearning.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseAllCourse {
    private long id;
    private String name;
    private String imageUrl;
}
