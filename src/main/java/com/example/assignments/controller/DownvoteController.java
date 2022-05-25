package com.example.assignments.controller;

import com.example.assignments.dto.DownvoteDTO;
import com.example.assignments.model.*;
import com.example.assignments.service.AnswerService;
import com.example.assignments.service.DownvoteService;
import com.example.assignments.service.PostService;
import com.example.assignments.service.UserService;
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

    @Autowired
    AnswerService answerService;

    @Autowired
    UserService userService;

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
        User targetUser;
        User sourceUser = downvoteDTO.getAuthor();
        if(downvoteDTO.getPost() != null) {
            downvote = new Downvote(downvoteDTO.getAuthor(), downvoteDTO.getPost());
            Post auxPost =  postService.getPostByTitle(downvote.getPost().getTitle());
            if (downvote.getPost().getPostid() == null){

                downvote.getPost().setPostid(auxPost.getPostid());
            }
            targetUser = userService.getUser(downvoteDTO.getPost().getPoster().getUserID());
            auxPost.setScore(auxPost.getScore()-1);
            targetUser.setScore(targetUser.getScore() - 2);
            postService.updatePost(auxPost);
        }
        else{
            downvote = new Downvote(downvoteDTO.getAuthor(), downvoteDTO.getAnswer());
            Answer auxAnswer = answerService.getAnswer(downvoteDTO.getAnswer().getAnswerID());
            auxAnswer.setScore(auxAnswer.getScore()- 1);

            targetUser = userService.getUser(downvoteDTO.getAnswer().getPoster().getUserID());
            targetUser.setScore(targetUser.getScore() - 2);

            sourceUser.setScore(sourceUser.getScore() - 1);

            answerService.updateAnswer(auxAnswer);
        }
        userService.saveUser(targetUser);
        userService.saveUser(sourceUser);
        return downvoteService.saveDownvote(downvote);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateDownvote")
    @ResponseBody
    public Downvote updateDownvote(@RequestBody Downvote downvote) {
        return downvoteService.updateDownvote(downvote);
    }
}
