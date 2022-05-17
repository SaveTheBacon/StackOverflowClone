package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer tagID;
    @Column(name = "content")
    String name;

    public Tag() {
    }

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }
}
