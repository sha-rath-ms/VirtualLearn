package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Outcomes;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "outcomes_tbl")
@AllArgsConstructor
public class OutcomesTable {
    @Id
    private long id;
    private String message;
    private long courseId;

    public OutcomesTable(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public Outcomes toOutcomes() {
        return new Outcomes(this.message, this.courseId);
    }
}
