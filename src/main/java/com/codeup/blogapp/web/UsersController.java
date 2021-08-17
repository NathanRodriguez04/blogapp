package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    private List<User> getUser(){
        return new ArrayList<>(){{
            add(new User(1l,"User", "new.email@gmail.com", "1234abcd", User.Role.USER));
        }};


    }

    @GetMapping("{id}")
    private User getUserById(@PathVariable Long id){

        if (id == 1){

            return new User(1L,"User","email@email.com",
                    "abcde1234", User.Role.USER);
        }else {
            return null;
        }
    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getPassword());
    }
    @PutMapping("/{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user){
        System.out.println(id);
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
    @DeleteMapping({"/{id}"})
    private void deleteUser(@PathVariable Long id){
        System.out.println("Deleting User with ID: " + id);
    }
}