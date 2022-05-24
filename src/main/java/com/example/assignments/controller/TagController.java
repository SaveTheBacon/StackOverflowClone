package com.example.assignments.controller;

import com.example.assignments.model.Tag;
import com.example.assignments.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Tag> getTags(){
        return tagService.getAllTags();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTag")
    @ResponseBody
    public Tag getTag(@RequestParam(name = "id") Integer id){
        return tagService.getTag(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTag")
    @ResponseBody
    public String deleteTag(@RequestParam(name = "id") Integer id) {
        return tagService.deleteTag(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveTag")
    @ResponseBody
    public Tag saveTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateTag")
    @ResponseBody
    public Tag updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }
}
