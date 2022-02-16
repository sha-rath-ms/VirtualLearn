package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "my_course_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class MyCourseTable {
    @Id
    private Long mobileNumber;
    private Long courseId;
}