package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CategoryTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public CategoryTable toCategoryTable() {
        return new CategoryTable(this.name);
    }
}
