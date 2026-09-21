package com.sumitdev.journal.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
public class JournalEntity {

    @Id
    private ObjectId id;

    private String title;
    private String content;

    private LocalDateTime localdate;

    public LocalDateTime getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDateTime localdate) {
        this.localdate = localdate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
