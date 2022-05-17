package com.example.assignments.controller;

import com.example.assignments.model.Downvote;
import com.example.assignments.service.DownvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/downvotes")
public class DownvoteController {

    @Autowired
    DownvoteService downvoteService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Downvote> getDownvotes(){
        return downvoteService.getAllDownvotes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getDownvote")
    @ResponseBody
    public Downvote getDownvote(@RequestParam(name = "id") Integer id){
        return downvoteService.getDownvote(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDownvote")
    @ResponseBody
    public String deleteDownvote(@RequestParam(name = "id") Integer id) {
        return downvoteService.deleteDownvote(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveDownvote")
    @ResponseBody
    public Downvote saveDownvote(@RequestBody Downvote downvote) {
        return downvoteService.saveDownvote(downvote);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateDownvote")
    @ResponseBody
    public Downvote updateDownvote(@RequestParam(name = "id") Integer id, @RequestBody Downvote downvote) {
        return downvoteService.updateDownvote(id, downvote);
    }
}
