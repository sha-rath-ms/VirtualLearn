package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="blocklist_tbl")
@Getter
@Setter
@AllArgsConstructor
@Entity
public class BlockListTable {
    @Id
    private String token;

    public BlockListTable() {
    }
}
