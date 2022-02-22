package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ads_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class AdsTable {
    @Id
    @Column(name = "course_id")
    private long courseId;
}
