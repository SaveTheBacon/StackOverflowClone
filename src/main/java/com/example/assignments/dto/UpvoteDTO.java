package com.example.assignments.dto;

import com.example.assignments.model.Answer;
import com.example.assignments.model.Post;
import com.example.assignments.model.User;

public class UpvoteDTO {

    private Answer answer;
    private Post post;
    private User author;

    public UpvoteDTO(Answer answer, User author) {
        this.answer = answer;
        this.author = author;
    }

    public UpvoteDTO(Post post, User author) {
        this.post = post;
        this.author = author;
    }

    public UpvoteDTO() {
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
