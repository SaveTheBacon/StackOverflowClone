package com.example.assignments.service;


import com.example.assignments.model.Downvote;
import com.example.assignments.repository.IDownvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DownvoteService {

    @Autowired
    IDownvoteRepository iDownvoteRepository;

    public List<Downvote> getAllDownvotes(){
        return (List<Downvote>) iDownvoteRepository.findAll();
    }

    public Downvote getDownvote(Integer ID){
        Optional<Downvote> downvote = iDownvoteRepository.findById(ID);
        return downvote.orElse(null);
    }

    public String deleteDownvote(Integer ID){
        try{
            iDownvoteRepository.delete(this.getDownvote(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public Downvote saveDownvote(Downvote downvote){
        return iDownvoteRepository.save(downvote);
    }

    public Downvote updateDownvote(Downvote downvote){
        return iDownvoteRepository.save(downvote);
    }
}
