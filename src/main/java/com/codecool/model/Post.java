package com.codecool.model;

public class Post {

    private String userID;
    private String content;

    public Post(String userID, String content) {
        this.userID = userID;
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public String getContent() {
        return content;
    }
}
