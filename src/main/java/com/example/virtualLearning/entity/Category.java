package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CategoryTable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private long id;
    private String name;

//    public Category(String name) {
//        this.name = name;
//    }

    public CategoryTable toCategoryTable() {
        return new CategoryTable(this.name);
    }
}
