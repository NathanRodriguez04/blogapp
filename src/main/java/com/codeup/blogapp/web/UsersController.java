package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    @GetMapping
    private List<User> getUser() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title", "content"));


        return new ArrayList<>() {{
            add(new User(1L, "Corey", "new.email@gmail.com", "1234qwerty", posts));

        }};


    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title", "content"));
        if (id == 1) {

            return new User(1L, "User", "email@email.com",
                    "qwasdf1234", posts);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getPassword());
    }

    @PutMapping("/{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(id);
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

    @DeleteMapping({"/{id}"})
    private void deleteUser(@PathVariable Long id) {
        System.out.println("Deleting User with ID: " + id);
    }

//    @GetMapping("/{id}")
//    private User findByID(@PathVariable Long id) {
//        return new User(1L, "User", "email@email.com", "password");
//
//    }

    @GetMapping("/findByUsername/{username}")
    private User findByUsername(@PathVariable String username) {

        return new User(1L, "User", "email@email.com", "password");
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email) {

        return new User(1L, "User", "email@email.com", "password");
    }


    @GetMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {

    }
}