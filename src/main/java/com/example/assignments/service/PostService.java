package com.example.assignments.service;


import com.example.assignments.model.Answer;
import com.example.assignments.model.Post;
import com.example.assignments.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    IPostRepository iPostRepository;

    public List<Post> getAllPosts(){
        List<Post> aux =  (List<Post>) iPostRepository.findAll();
        aux.stream().sorted(new Comparator<Post>() {
            @Override
            public int compare(Post post, Post t1) {
                return t1.getCreationDate().compareTo(post.getCreationDate());
            }
        }).collect(Collectors.toList());
        Collections.reverse(aux);
        return aux;
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
