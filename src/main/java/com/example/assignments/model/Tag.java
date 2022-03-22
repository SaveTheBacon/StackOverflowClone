package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer tagID;
    @Column(name = "content")
    String name;
    @Column(name = "number_of_appearances")
    Integer nrOfAppearances;

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

    public Integer getNrOfAppearances() {
        return nrOfAppearances;
    }

    public void setNrOfAppearances(Integer nrOfAppearances) {
        this.nrOfAppearances = nrOfAppearances;
    }

    public Tag(Integer tagID, String name) {
        this.tagID = tagID;
        this.name = name;
    }
}
