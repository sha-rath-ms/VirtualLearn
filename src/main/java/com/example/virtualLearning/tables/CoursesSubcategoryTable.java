package com.example.virtualLearning.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course_subcategory_tbl")
@NoArgsConstructor
public class CoursesSubcategoryTable {
    @Id
    private long id;
    private long courseId;
    private long subcategoryId;

}
