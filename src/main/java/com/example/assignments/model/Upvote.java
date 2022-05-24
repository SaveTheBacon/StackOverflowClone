package com.example.assignments.model;

import javax.persistence.*;


@Entity
public class Upvote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer UpvoteID;
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
        UpvoteID = upvoteID;
        this.voter = voter;
        this.post = post;
    }

    public Upvote(Integer upvoteID, User voter, Answer answer) {
        UpvoteID = upvoteID;
        this.voter = voter;
        this.answer = answer;
    }

    public Upvote() {
    }

    public Integer getUpvoteID() {
        return UpvoteID;
    }

    public void setUpvoteID(Integer upvoteID) {
        UpvoteID = upvoteID;
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
