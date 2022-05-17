package com.example.assignments.controller;

import com.example.assignments.model.TagLinker;
import com.example.assignments.service.TagLinkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tagLinkers")
public class TagLinkerController {

    @Autowired
    TagLinkerService tagLinkerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<TagLinker> getTagLinkers(){
        return tagLinkerService.getAllTagLinkers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTagLinker")
    @ResponseBody
    public TagLinker getTagLinker(@RequestParam(name = "id") Integer id){
        return tagLinkerService.getTagLinker(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTagLinker")
    @ResponseBody
    public String deleteTagLinker(@RequestParam(name = "id") Integer id) {
        return tagLinkerService.deleteTagLinker(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveTagLinker")
    @ResponseBody
    public TagLinker saveTagLinker(@RequestBody TagLinker tagLinker) {
        return tagLinkerService.saveTagLinker(tagLinker);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateTagLinker")
    @ResponseBody
    public TagLinker updateTagLinker(@RequestParam(name = "id") Integer id, @RequestBody TagLinker tagLinker) {
        return tagLinkerService.updateTagLinker(id, tagLinker);
    }
}
