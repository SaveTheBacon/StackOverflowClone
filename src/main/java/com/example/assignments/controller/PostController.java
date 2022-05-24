package com.example.assignments.controller;


import com.example.assignments.dto.PostDTO;
import com.example.assignments.model.*;
import com.example.assignments.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    TagLinkerController tagLinkerController;
    @Autowired
    AnswerController answerController;
    @Autowired
    UpvoteController upvoteController;
    @Autowired
    DownvoteController downvoteController;
    @Autowired
    TagController tagController;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<PostDTO> getPosts(){
        List<Answer> allAnswers = answerController.getAnswers();
        List<TagLinker> tagLinkers = tagLinkerController.getTagLinkers();
        List<Upvote> allUpvotes = upvoteController.getUpvotes();
        List<Downvote> allDownvotes = downvoteController.getDownvotes();

        
        List<Post> posts = postService.getAllPosts();
        List<PostDTO> finalList = new ArrayList<>();
        for(Post post: posts){
            List<Answer> auxAnswers = new ArrayList<>();
            for(Answer answer: allAnswers){
                if (answer.getPost().getPostid().equals(post.getPostid())){
                    auxAnswers.add(answer);
                }
            }

        List<Tag> auxTags = new ArrayList<>();
        for(TagLinker tagLinker: tagLinkers){
            if(tagLinker.getPost().getPostid().equals(post.getPostid())){
                auxTags.add(tagLinker.getTag());
            }
        }
        List<Upvote> auxUpvotes = new ArrayList<>();
        for(Upvote upvote: allUpvotes){
            if(upvote.getPost().getPostid().equals(post.getPostid())){
                auxUpvotes.add(upvote);
            }
        }
        List<Downvote> auxDownvotes = new ArrayList<>();
        for(Downvote downvote: allDownvotes){
            if(downvote.getPost().getPostid().equals(post.getPostid())){
                auxDownvotes.add(downvote);
            }
        }

        PostDTO auxDTO = new PostDTO(post.getPostid(), post.getContent(), post.getScore(), post.getCreationDate(), auxUpvotes, auxDownvotes, post.getTitle(), post.getPoster(), auxTags, auxAnswers );
        finalList.add(auxDTO);

        }
        return finalList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPost")
    @ResponseBody
    public PostDTO getPost(@RequestParam(name = "id") Integer id){

        Post post = postService.getPost(id);

        List<Answer> allAnswers = answerController.getAnswers();
        List<TagLinker> tagLinkers = tagLinkerController.getTagLinkers();
        List<Upvote> allUpvotes = upvoteController.getUpvotes();
        List<Downvote> allDownvotes = downvoteController.getDownvotes();

        List<Answer> auxAnswers = new ArrayList<>();
        for(Answer answer: allAnswers){
            if (answer.getPost().getPostid().equals(post.getPostid())){
                auxAnswers.add(answer);
            }
        }

        List<Tag> auxTags = new ArrayList<>();
        for(TagLinker tagLinker: tagLinkers){
            if(tagLinker.getPost().getPostid().equals(post.getPostid())){
                auxTags.add(tagLinker.getTag());
            }
        }
        List<Upvote> auxUpvotes = new ArrayList<>();
        for(Upvote upvote: allUpvotes){
            if(upvote.getPost().getPostid().equals(post.getPostid())){
                auxUpvotes.add(upvote);
            }
        }
        List<Downvote> auxDownvotes = new ArrayList<>();
        for(Downvote downvote: allDownvotes){
            if(downvote.getPost().getPostid().equals(post.getPostid())){
                auxDownvotes.add(downvote);
            }
        }

        PostDTO postDTO = new PostDTO(post, auxUpvotes, auxDownvotes, auxTags, auxAnswers);
        return postDTO ;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePost")
    @ResponseBody
    public String deletePost(@RequestParam(name = "id") Integer id) {
        return postService.deletePost(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savePost")
    @ResponseBody
    public Post savePost(@RequestBody PostDTO postDTO) {
        Post auxPost = new Post(postDTO);
        List<Tag> currentTags = postDTO.getTags();
        List<Tag> allTags = tagController.getTags();
        List<String> tagNames = allTags.stream().map(Tag::getName).collect(Collectors.toList());
        for(Tag tag: currentTags){
            if (!tagNames.contains(tag.getName())){
                Tag auxTag = new Tag(tag.getName());
                tagController.saveTag(auxTag);
            }
        }
        return postService.savePost(auxPost);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatePost")
    @ResponseBody
    public Post updatePost(@RequestParam(name = "id") Integer id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }



}
