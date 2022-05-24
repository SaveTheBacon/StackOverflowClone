package com.example.assignments.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerID;
    @Column(name = "score")
    Integer score;
    @Column(name = "date")
    private Date date;
    @Column(name = "content")
    String content;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User poster;

    @ManyToOne
    @JoinColumn(name = "Post_ID")
    private Post post;

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



    public Answer(String content) {
        this.content = content;
    }

    public Answer(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
