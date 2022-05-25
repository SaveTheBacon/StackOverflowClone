package com.example.assignments.controller;

import com.example.assignments.dto.UpvoteDTO;
import com.example.assignments.model.Answer;
import com.example.assignments.model.Post;
import com.example.assignments.model.Upvote;
import com.example.assignments.model.User;
import com.example.assignments.service.AnswerService;
import com.example.assignments.service.PostService;
import com.example.assignments.service.UpvoteService;
import com.example.assignments.service.UserService;
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

    @Autowired
    PostService postService;

    @Autowired
    AnswerService answerService;

    @Autowired
    UserService userService;

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
    public Upvote saveUpvote(@RequestBody UpvoteDTO upvoteDTO) {
        Upvote upvote;
        User targetUser;

        if(upvoteDTO.getPost() != null) {
            targetUser = userService.getUser(upvoteDTO.getPost().getPoster().getUserID()) ;
            upvote = new Upvote(upvoteDTO.getAuthor(), upvoteDTO.getPost());

            Post auxPost =  postService.getPostByTitle(upvote.getPost().getTitle());
            if (upvote.getPost().getPostid() == null){

               upvote.getPost().setPostid(auxPost.getPostid());
            }

            targetUser.setScore(targetUser.getScore() + 5);

            auxPost.setScore(auxPost.getScore()+1);
            postService.updatePost(auxPost);
        }
        else{
            targetUser = userService.getUser(upvoteDTO.getAnswer().getPoster().getUserID()) ;
            upvote = new Upvote(upvoteDTO.getAuthor(), upvoteDTO.getAnswer());
            Answer auxAnswer = answerService.getAnswer(upvoteDTO.getAnswer().getAnswerID());
            auxAnswer.setScore(auxAnswer.getScore()+ 1);

            targetUser.setScore(targetUser.getScore() + 10);

            answerService.updateAnswer(auxAnswer);
        }
        userService.saveUser(targetUser);
        return upvoteService.saveUpvote(upvote);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateUpvote")
    @ResponseBody
    public Upvote updateUpvote(@RequestBody Upvote upvote) {
        return upvoteService.updateUpvote(upvote);
    }
}
