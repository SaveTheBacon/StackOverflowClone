package com.example.assignments.model;


import com.example.assignments.dto.PostDTO;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postid;
    @Column(name = "content")
    private String content;
    @Column(name = "score")
    private Integer score;
    @Column(name = "creation_date")
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User poster;
    @Column(name = "title")
    private String title;


    public Post(){

    }

    public Post(PostDTO postDTO){
        this.content = postDTO.getContent();
        this.poster = postDTO.getAuthor();
        this.title = postDTO.getTitle();
        this.creationDate = postDTO.getCreationDate();
        this.score = postDTO.getScore();

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

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }
}
