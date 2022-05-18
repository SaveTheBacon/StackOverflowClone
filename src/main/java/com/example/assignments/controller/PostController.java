package com.example.assignments.controller;


import com.example.assignments.model.Post;
import com.example.assignments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Post> getPosts(){
        var a = postService.getAllPosts();
        System.out.println(a.get(0));
        return a;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPost")
    @ResponseBody
    public Post getPost(@RequestParam(name = "id") Integer id){
        return postService.getPost(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePost")
    @ResponseBody
    public String deletePost(@RequestParam(name = "id") Integer id) {
        return postService.deletePost(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savePost")
    @ResponseBody
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatePost")
    @ResponseBody
    public Post updatePost(@RequestParam(name = "id") Integer id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }



}
