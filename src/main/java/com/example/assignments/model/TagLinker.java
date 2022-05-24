package com.example.assignments.model;


import javax.persistence.*;

@Entity
@Table(name = "taglinker")
public class TagLinker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer taglinkerID;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public TagLinker() {
    }

    public TagLinker(Integer taglinkerID, Post post, Tag tag) {
        this.taglinkerID = taglinkerID;
        this.post = post;
        this.tag = tag;
    }

    public Integer getTaglinkerID() {
        return taglinkerID;
    }

    public void setTaglinkerID(Integer taglinkerID) {
        this.taglinkerID = taglinkerID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
