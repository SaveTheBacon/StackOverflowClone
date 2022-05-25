package com.example.assignments.dto;

import com.example.assignments.model.Answer;
import com.example.assignments.model.Post;
import com.example.assignments.model.User;

public class DownvoteDTO {

    private Answer answer;
    private Post post;
    private User author;

    public DownvoteDTO(Answer answer, User author) {
        this.answer = answer;
        this.author = author;
    }

    public DownvoteDTO(Answer answer, Post post) {
        this.answer = answer;
        this.post = post;
    }

    public DownvoteDTO() {
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
