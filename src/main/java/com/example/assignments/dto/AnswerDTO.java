package com.example.assignments.dto;

import com.example.assignments.model.Downvote;
import com.example.assignments.model.Post;
import com.example.assignments.model.Upvote;
import com.example.assignments.model.User;

import java.sql.Date;
import java.util.List;

public class AnswerDTO {

    private Integer answerID;
    private Integer score;
    private String content;
    private User user;
    private PostDTO postDTO;
    private Date date;
    private List<Upvote> upvotes;
    private List<Downvote> downvotes;

    public AnswerDTO(Integer score, Date date, String content, User user, PostDTO postDTO, List<Upvote> upvotes, List<Downvote> downvotes) {
        this.score = score;
        this.date = date;
        this.content = content;
        this.user = user;
        this.postDTO = postDTO;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostDTO getPost() {
        return postDTO;
    }

    public void setPost(PostDTO post) {
        this.postDTO = post;
    }

    public List<Upvote> getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(List<Upvote> upvotes) {
        this.upvotes = upvotes;
    }

    public List<Downvote> getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(List<Downvote> downvotes) {
        this.downvotes = downvotes;
    }
}
