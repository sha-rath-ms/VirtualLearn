package com.example.virtualLearning.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class GetTimeStamp {
    @NotNull
    private Timestamp timestamp;
    @NotNull
    private boolean completed;
}
