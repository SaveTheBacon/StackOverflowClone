package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerID;
    @Column(name = "score")
    Integer score;
    @Column(name = "content")
    String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private User poster;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Post_ID")
    private Post post;

    public Answer(String content) {
        this.content = content;
    }

    public Answer(){

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
