package com.example.assignments.controller;

import com.example.assignments.model.Upvote;
import com.example.assignments.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/upvotes")
public class UpvoteController {

    @Autowired
    UpvoteService upvoteService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Upvote> getUpvotes(){
        return upvoteService.getAllUpvotes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUpvote")
    @ResponseBody
    public Upvote getUpvote(@RequestParam(name = "id") Integer id){
        return upvoteService.getUpvote(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUpvote")
    @ResponseBody
    public String deleteUpvote(@RequestParam(name = "id") Integer id) {
        return upvoteService.deleteUpvote(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveUpvote")
    @ResponseBody
    public Upvote saveUpvote(@RequestBody Upvote upvote) {
        return upvoteService.saveUpvote(upvote);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateUpvote")
    @ResponseBody
    public Upvote updateUpvote(@RequestParam(name = "id") Integer id, @RequestBody Upvote upvote) {
        return upvoteService.updateUpvote(id, upvote);
    }
}
