package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Outcomes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "outcomes_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class OutcomesTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @Column(name = "course_id")
    private long courseId;

    public OutcomesTable(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public Outcomes toOutcomes() {
        return new Outcomes(this.message, this.courseId);
    }
}

