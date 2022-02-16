package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Benefits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "benefits_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BenefitsTable {
    @Id
    private long id;
    private String message;
    private long courseId;

    public BenefitsTable(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public Benefits toBenefit() {
        return new Benefits(this.message, this.courseId);
    }
}
