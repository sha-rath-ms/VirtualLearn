package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.SubcategoryTable;
import lombok.Data;

@Data
public class Subcategory {
    private long id;
    private String name;
    private String categoryId;

    public Subcategory(String name, String categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubcategoryTable toSubcategoryTable() {
        return new SubcategoryTable(this.name, this.categoryId);
    }
}
