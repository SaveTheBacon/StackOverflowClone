package com.example.assignments.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;
    @Column(name = "content")
    private String content;
    @Column(name = "score")
    private Integer score;
    @Column(name = "creation_date")
    private GregorianCalendar creationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private User poster;
    @Column(name = "title")
    private String title;


    public Post(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post(String content) {
        this.content = content;
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
}
