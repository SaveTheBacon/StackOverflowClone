package com.example.assignments.service;


import com.example.assignments.model.Upvote;
import com.example.assignments.repository.IUpvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpvoteService {

    @Autowired
    IUpvoteRepository iUpvoteRepository;

    public List<Upvote> getAllUpvotes(){
        return (List<Upvote>) iUpvoteRepository.findAll();
    }

    public Upvote getUpvote(Integer ID){
        Optional<Upvote> upvote = iUpvoteRepository.findById(ID);
        return upvote.orElse(null);
    }

    public String deleteUpvote(Integer ID){
        try{
            iUpvoteRepository.delete(this.getUpvote(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public Upvote saveUpvote(Upvote upvote){
        return iUpvoteRepository.save(upvote);
    }

    public Upvote updateUpvote(Upvote upvote){
        return iUpvoteRepository.save(upvote);
    }
}
