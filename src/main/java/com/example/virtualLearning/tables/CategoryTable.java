package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category_tbl")
@AllArgsConstructor
public class CategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public CategoryTable(String name) {
        this.name = name;
    }

    public Category toCategory() {
        return new Category(this.id,this.name);
    }
}
