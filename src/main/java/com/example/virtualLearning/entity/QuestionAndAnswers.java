package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.QuestionAndAnswersTable;
import lombok.Data;

import javax.validation.constraints.NotNull;

import static com.example.virtualLearning.extract.ConvertOptions.getConcatenatedOptions;

@Data
public class QuestionAndAnswers {
    private long id;
    @NotNull
    private String question;
    @NotNull
    private String optionA;
    @NotNull
    private String optionB;
    @NotNull
    private String optionC;
    @NotNull
    private String optionD;
    @NotNull
    private String answer;
    @NotNull
    private long chapterTestId;

    public QuestionAndAnswers(long id, String question, String optionA, String optionB, String optionC, String optionD, String answer, long chapterTestId) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.chapterTestId = chapterTestId;
    }

    public QuestionAndAnswersTable questionAndAnswersTable() {
        return new QuestionAndAnswersTable(this.question, getConcatenatedOptions(this.optionA, this.optionB, this.optionC, this.optionD), this.answer, this.chapterTestId);
    }
}
