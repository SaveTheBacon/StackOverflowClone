package com.example.assignments.controller;

import com.example.assignments.dto.DownvoteDTO;
import com.example.assignments.model.Downvote;
import com.example.assignments.model.Post;
import com.example.assignments.model.Upvote;
import com.example.assignments.service.DownvoteService;
import com.example.assignments.service.PostService;
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

    @Autowired
    PostService postService;

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
    public Downvote saveDownvote(@RequestBody DownvoteDTO downvoteDTO) {
        Downvote downvote;
        if(downvoteDTO.getPost() != null) {
            downvote = new Downvote(downvoteDTO.getAuthor(), downvoteDTO.getPost());
            if (downvote.getPost().getPostid() == null){
                Post auxPost =  postService.getPostByTitle(downvote.getPost().getTitle());
                downvote.getPost().setPostid(auxPost.getPostid());
            }
        }
        else{
            downvote = new Downvote(downvoteDTO.getAuthor(), downvoteDTO.getAnswer());
        }
        return downvoteService.saveDownvote(downvote);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateDownvote")
    @ResponseBody
    public Downvote updateDownvote(@RequestBody Downvote downvote) {
        return downvoteService.updateDownvote(downvote);
    }
}
