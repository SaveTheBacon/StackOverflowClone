package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class Downvote {

    public Downvote() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer DownvoteID;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User voter;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "Answer_ID")
    private Answer answer;

    public Downvote(Integer downvoteID, User voter, Post post) {
        DownvoteID = downvoteID;
        this.voter = voter;
        this.post = post;
    }

    public Downvote(Integer downvoteID, User voter, Answer answer) {
        DownvoteID = downvoteID;
        this.voter = voter;
        this.answer = answer;
    }

    public Integer getDownvoteID() {
        return DownvoteID;
    }

    public void setDownvoteID(Integer downvoteID) {
        DownvoteID = downvoteID;
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
