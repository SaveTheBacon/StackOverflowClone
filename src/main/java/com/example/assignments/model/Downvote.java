package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class Downvote {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer downvoteID;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User voter;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "Answer_ID")
    private Answer answer;

    public Downvote() {
    }

    public Downvote(Integer downvoteID, User voter, Post post) {
        downvoteID = downvoteID;
        this.voter = voter;
        this.post = post;
    }

    public Downvote(Integer downvoteID, User voter, Answer answer) {
        downvoteID = downvoteID;
        this.voter = voter;
        this.answer = answer;
    }

    public Downvote(User voter, Post post) {
        this.downvoteID = null;
        this.voter = voter;
        this.post = post;
    }

    public Downvote(User voter, Answer answer) {
        this.downvoteID = null;
        this.voter = voter;
        this.answer = answer;
    }

    public Integer getDownvoteID() {
        return downvoteID;
    }

    public void setDownvoteID(Integer downvoteID) {
        this.downvoteID = downvoteID;
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
