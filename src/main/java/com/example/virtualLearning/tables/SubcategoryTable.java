package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Subcategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subcategory_tbl")
@NoArgsConstructor
public class SubcategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(name = "category_id")
    private long categoryId;

    public SubcategoryTable(String name, long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Subcategory toSubcategory() {
        return new Subcategory(this.name, this.categoryId);
    }
}
