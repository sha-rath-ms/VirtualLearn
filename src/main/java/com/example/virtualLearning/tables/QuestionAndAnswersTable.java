package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.QuestionAndAnswers;
import com.example.virtualLearning.extract.ConvertOptions;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "quiz_tbl")
@AllArgsConstructor
public class QuestionAndAnswersTable {
    private long id;
    private String question;
    private String options;
    private String answer;
    private long chapterTestId;

    public QuestionAndAnswersTable(String question, String options, String answer, long chapterTestId) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.chapterTestId = chapterTestId;
    }

    public QuestionAndAnswers questionAndAnswers() {
        String[] getOptions = ConvertOptions.getOptions(this.options);
        return new QuestionAndAnswers(this.id, this.question, getOptions[0], getOptions[1], getOptions[2], getOptions[3], this.answer, this.chapterTestId);
    }
}
