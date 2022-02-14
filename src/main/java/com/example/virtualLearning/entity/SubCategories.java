package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.SubcategoryTable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubCategories {
    private final Category category;
    private final String subcategory;

    public SubcategoryTable toSubcategoryTable() {
        return new SubcategoryTable(this.category, this.subcategory);
    }
}
