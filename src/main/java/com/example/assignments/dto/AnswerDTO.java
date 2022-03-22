package com.example.assignments.dto;

public class AnswerDTO {

    private Integer answerID;
    private Integer score;
    private String content;
    private Integer userID;
    private Integer PostID;
    private Integer upvotes;
    private Integer downvotes;

    public AnswerDTO(Integer answerID, Integer score, String content, Integer userID, Integer postID, Integer upvotes, Integer downvotes) {
        this.answerID = answerID;
        this.score = score;
        this.content = content;
        this.userID = userID;
        PostID = postID;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public AnswerDTO() {
    }

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPostID() {
        return PostID;
    }

    public void setPostID(Integer postID) {
        PostID = postID;
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

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }
}
