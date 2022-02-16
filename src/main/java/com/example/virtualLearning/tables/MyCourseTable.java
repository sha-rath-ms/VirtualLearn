package com.example.virtualLearning.tables;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "benefits_tbl")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MyCourseTable {
    @Id
    private Long mobileNumber;
    private Long courseId;
   }
