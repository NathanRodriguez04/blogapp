package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Annotation goes here to Annotate
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
//With the @RequestMapping annotation,
// we are informing Spring of how to direct requests to PostsController,
// as well as what type of data is accepted.
public class PostsController {
    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping
    //This handy annotation is what is called a composed annotation.
    // @GetMapping is a composed annotation that acts as a shortcut for
    // @RequestMapping(method = RequestMethod.GET).
    private List<Post> getPosts() {

        return postsRepository.findAll();
    }


    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        // /api/posts/1
        return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
    }
    @PutMapping("/{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(id);
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        postsRepository.save(post);
    }
    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("Deleting Post with ID: " + id);
        postsRepository.deleteById(id);
    }


}