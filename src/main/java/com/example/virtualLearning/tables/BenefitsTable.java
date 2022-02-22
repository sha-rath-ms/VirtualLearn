package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Benefits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "benefits_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BenefitsTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @Column(name = "course_id")
    private long courseId;

    public BenefitsTable(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public Benefits toBenefit() {
        return new Benefits(this.message, this.courseId);
    }
}

