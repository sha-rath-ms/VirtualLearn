package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Content;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "content_tbl")
@NoArgsConstructor
public class ContentTable {
    @Id
    private long id;
    @Column(name = "content_url")
    private String contentUrl;
    private boolean completed;
    @Column(name = "chapter_id")
    private long chapterId;
    @Getter
    @Setter
    @Column(name = "time_stamp")
    private String timeStamp;

    public ContentTable(String contentUrl, boolean completed, long chapterId) {
        this.contentUrl = contentUrl;
        this.completed = completed;
        this.chapterId = chapterId;
    }

    public Content toContent()
    {
        return new Content(this.id,this.contentUrl,this.completed);
    }
}
