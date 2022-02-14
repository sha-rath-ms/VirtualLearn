package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.entity.SubCategories;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubcategoryTable {
    private Category category;
    private String subcategory;

    public SubCategories toSubcategories() {
        return new SubCategories(this.category, this.subcategory);
    }
}
