package com.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codeblog.model.Post;
import com.codeblog.service.DefaultService;

@Controller
public class PostController {
    @Autowired
    private DefaultService<Post> service;

    @RequestMapping(value = "/posts")
    @GetMapping
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        return mv.addObject("posts", posts);
    }
    
}
