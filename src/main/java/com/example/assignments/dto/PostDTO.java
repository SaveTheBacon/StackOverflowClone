package com.example.assignments.dto;


import com.example.assignments.model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class PostDTO {

    private Integer postID;
    private String title;
    private String content;
    private Integer score;
    private Date creationDate;
    private User author;
    private List<Tag> tags;
    private List<Upvote> upvotes;
    private List<Downvote> downvotes;
    private List<Answer> answers;



    public PostDTO(Integer postID, String content, Integer score, Date creationDate, List<Upvote> upvotes, List<Downvote> downvotes, String title, User author, List<Tag> tags, List<Answer> answers) {
        this.postID = postID;
        this.content = content;
        this.score = score;
        this.creationDate = creationDate;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.title = title;
        this.author = author;
        this.tags = tags;
        this.answers = answers;
    }
    public PostDTO(Post post, List<Upvote> upvotes, List<Downvote> downvotes, List<Tag> tags, List<Answer> answers){
        this.postID = post.getPostid();
        this.content = post.getContent();
        this.score = post.getScore();
        this.creationDate = post.getCreationDate();
        this.title = post.getTitle();
        this.author = post.getPoster();
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.tags = tags;
        this.answers = answers;

    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public PostDTO() {
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
