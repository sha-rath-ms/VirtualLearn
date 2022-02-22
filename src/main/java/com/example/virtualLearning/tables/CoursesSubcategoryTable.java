package com.example.virtualLearning.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course_subcategory_tbl")
@NoArgsConstructor
public class CoursesSubcategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "course_id")
    private long courseId;
    @Column(name = "subcategory_id")
    private long subcategoryId;

    public CoursesSubcategoryTable(long courseId, long subcategoryId) {
        this.courseId = courseId;
        this.subcategoryId = subcategoryId;
    }
}
