package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Subcategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subcategory_tbl")
@NoArgsConstructor
public class SubcategoryTable {
    @Id
    private long id;
    private String name;
    private String categoryId;

    public SubcategoryTable(String name, String categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Subcategory toSubcategory() {
        return new Subcategory(this.name, this.categoryId);
    }
}
