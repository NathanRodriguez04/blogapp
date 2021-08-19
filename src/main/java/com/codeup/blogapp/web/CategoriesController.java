package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/categories", headers = "application/json")
public class CategoriesController {
    public CategoriesController() {
    }

    @GetMapping
    private List<Category> getCategories(){
        return null;

    }

}
//public class CategoriesController {
//
//    private Object Category;
//
//    private Object getPostsByCategory(@RequestParam String categoryName){
//        return Category;
//    }
//
//    public CategoriesController(Object category) {
//        Category = category;
//    }
//}