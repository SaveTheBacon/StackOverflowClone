package com.example.assignments.model;

import javax.persistence.*;


@Entity
public class Upvote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer upvoteID;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User voter;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "Answer_ID")
    private Answer answer;

    public Upvote(Integer upvoteID, User voter, Post post) {
        this.upvoteID = upvoteID;
        this.voter = voter;
        this.post = post;
    }

    public Upvote(Integer upvoteID, User voter, Answer answer) {
        this.upvoteID = upvoteID;
        this.voter = voter;
        this.answer = answer;
    }

    public Upvote(User voter, Post post) {
        this.upvoteID = null;
        this.voter = voter;
        this.post = post;
    }

    public Upvote(User voter, Answer answer) {
        this.upvoteID = null;
        this.voter = voter;
        this.answer = answer;
    }

    public Upvote() {
    }

    public Integer getUpvoteID() {
        return upvoteID;
    }

    public void setUpvoteID(Integer upvoteID) {
        this.upvoteID = upvoteID;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
