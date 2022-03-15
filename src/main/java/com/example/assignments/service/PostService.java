package com.example.assignments.service;


import com.example.assignments.model.Answer;
import com.example.assignments.model.Post;
import com.example.assignments.repository.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    IPostRepository iPostRepository;

    public List<Post> getAllPosts(){
        return (List<Post>) iPostRepository.findAll();
    }

    public Post getPost(Integer ID){
        Optional<Post> post = iPostRepository.findById(ID);
        return post.orElse(null);
    }

    public String deletePost(Integer ID){
        try{
            iPostRepository.delete(this.getPost(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public Post savePost(Post post){
        return iPostRepository.save(post);
    }

    public Post updatePost(Integer id, Post post){
        Post initialPost = this.getPost(id);
        return iPostRepository.save(initialPost);
    }
}
