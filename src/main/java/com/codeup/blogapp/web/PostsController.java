package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Annotation goes here to Annotate
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
//With the @RequestMapping annotation,
// we are informing Spring of how to direct requests to PostsController,
// as well as what type of data is accepted.
public class PostsController {

    @GetMapping
    //This handy annotation is what is called a composed annotation.
    // @GetMapping is a composed annotation that acts as a shortcut for
    // @RequestMapping(method = RequestMethod.GET).
    private List<Post> getPost() {

        User user = new User(1L,"coco","thy@email.com","pwd");

        return new ArrayList<>() {{
            add(new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", user));
            add(new Post(2L, "a newer post",
                    "this is slightly longer. 11/10", user));
            add(new Post(3L, "A new post",
                    "this is even longer. 12/10", user));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        // /api/posts/1
        if (id == 1) {

            return new Post(1L, "A new Post",
                    "this is a brilliant post. 10/10", new User("coco"));
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }
    @PutMapping("/{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(id);
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
    }
    @DeleteMapping({"/{id}"})
    private void deletePost(@PathVariable Long id){
        System.out.println("Deleting Post with ID: " + id);
    }


}