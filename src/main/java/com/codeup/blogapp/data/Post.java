package com.codeup.blogapp.data;

public class Post {
    //Fields go inside
    private Long id;
    private String title;
    private String content;
    //empty Constructor window key/command + n. select constructor.
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}