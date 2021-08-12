package com.codeup.blogapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {


    @RequestMapping({"/", "/about", "/posts", "/login", "/home"})
    public String showValue() {
        return "forward:/index.html";
    }

}