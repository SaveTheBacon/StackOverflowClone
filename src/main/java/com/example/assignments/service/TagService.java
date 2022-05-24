package com.example.assignments.service;


import com.example.assignments.model.Tag;
import com.example.assignments.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    ITagRepository iTagRepository;

    public List<Tag> getAllTags(){
        return (List<Tag>) iTagRepository.findAll();
    }

    public Tag getTag(Integer ID){
        Optional<Tag> tag = iTagRepository.findById(ID);
        return tag.orElse(null);
    }

    public Tag getTagByString(String name){
        Optional<Tag> tag = iTagRepository.findTagByName(name);
        return tag.orElse(null);
    }
    public String deleteTag(Integer ID){
        try{
            iTagRepository.delete(this.getTag(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public Tag saveTag(Tag tag){



        return iTagRepository.save(tag);
    }

    public Tag updateTag(Tag tag){
        return iTagRepository.save(tag);
    }
}
