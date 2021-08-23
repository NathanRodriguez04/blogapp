package com.codeup.blogapp.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Collection<Post> posts;


    public Category(Collection<Post> posts) {
        this.posts = posts;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

