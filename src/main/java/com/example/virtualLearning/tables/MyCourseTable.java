package com.example.virtualLearning.tables;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "my_course_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyCourseTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "mobile_number")
    private Long mobileNumber;
    @Column(name = "course_id")
    private Long courseId;
    private boolean completed;
    private String notes;
    private String certificate;

    public MyCourseTable(Long mobileNumber,Long courseId){
        this.mobileNumber=mobileNumber;
        this.courseId=courseId;
    }

    public void setCerticateDetails(){
        if(this.completed){
            //TODO: Generate certificate ID or anything else if required
            this.certificate="You have completed course with id " +this.courseId;
        }
    }
}
