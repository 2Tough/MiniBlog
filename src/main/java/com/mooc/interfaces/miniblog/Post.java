package com.mooc.interfaces.miniblog;

import java.time.LocalDateTime;

public class Post {
    private final int id;
    private String title;
    private String content;
    private final LocalDateTime date;

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
