package com.example.assignments.dto;


import java.util.GregorianCalendar;

public class PostDTO {

    private Integer postID;
    private String content;
    private Integer score;
    private GregorianCalendar creationDate;
    private Integer userID;
    private Integer upvotes;
    private Integer downvotes;
    private String title;

    public PostDTO(Integer postID, String content, Integer score, GregorianCalendar creationDate, Integer userID, Integer upvotes, Integer downvotes, String title) {
        this.postID = postID;
        this.content = content;
        this.score = score;
        this.creationDate = creationDate;
        this.userID = userID;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.title = title;
    }

    public PostDTO() {
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }
}
