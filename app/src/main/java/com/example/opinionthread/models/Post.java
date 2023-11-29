package com.example.opinionthread.models;

import java.util.Date;

public class Post {

    private int id;
    private String title;
    private String description;
    private String author;
    private int upvoteCount;
    private int downVoteCount;
    private Date date;

    public Post() {
    }

    public Post(int id, String title, String description, String author, int upvoteCount, int downVoteCount, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.upvoteCount = upvoteCount;
        this.downVoteCount = downVoteCount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(int upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
