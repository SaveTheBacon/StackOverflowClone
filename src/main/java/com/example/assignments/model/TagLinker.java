package com.example.assignments.model;


import javax.persistence.*;

@Entity
public class TagLinker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer linkID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_ID")
    private Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_ID")
    private Tag tag;

    public TagLinker() {
    }

    public Integer getLinkID() {
        return linkID;
    }

    public void setLinkID(Integer linkID) {
        this.linkID = linkID;
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

    public TagLinker(Integer linkID, Post post, Tag tag) {
        this.linkID = linkID;
        this.post = post;
        this.tag = tag;
    }
}
