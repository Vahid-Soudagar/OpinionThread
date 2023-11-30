package com.example.opinionthread.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.io.Serializable;


@Entity(tableName = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "author")
    private String author;
    @ColumnInfo(name = "upvotecount")
    private int upvoteCount;
    @ColumnInfo(name = "downvotecount")
    private int downVoteCount;
    @ColumnInfo(name = "date")
    private String date;

    @Ignore
    public Post() {
    }

    @Ignore

    public Post(int id, String title, String description, String author, int upvoteCount, int downVoteCount, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.upvoteCount = upvoteCount;
        this.downVoteCount = downVoteCount;
        this.date = date;
    }

    public Post(String title, String description, String author, int upvoteCount, int downVoteCount, String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
