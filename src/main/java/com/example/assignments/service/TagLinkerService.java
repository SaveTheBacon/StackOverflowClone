package com.example.assignments.service;


import com.example.assignments.model.TagLinker;
import com.example.assignments.repository.ITagLinkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagLinkerService {

    @Autowired
    ITagLinkerRepository iTagLinkerRepository;

    public List<TagLinker> getAllTagLinkers(){
        return (List<TagLinker>) iTagLinkerRepository.findAll();
    }

    public TagLinker getTagLinker(Integer ID){
        Optional<TagLinker> tagLinker = iTagLinkerRepository.findById(ID);
        return tagLinker.orElse(null);
    }

    public String deleteTagLinker(Integer ID){
        try{
            iTagLinkerRepository.delete(this.getTagLinker(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public TagLinker saveTagLinker(TagLinker tagLinker){
        return iTagLinkerRepository.save(tagLinker);
    }

    public TagLinker updateTagLinker(Integer id, TagLinker tagLinker){
        TagLinker initialTagLinker = this.getTagLinker(id);
        return iTagLinkerRepository.save(initialTagLinker);
    }
    
    
}
