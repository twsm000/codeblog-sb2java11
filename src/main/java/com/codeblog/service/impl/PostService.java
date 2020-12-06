package com.codeblog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeblog.model.Post;
import com.codeblog.repository.PostRepository;
import com.codeblog.service.DefaultService;

@Service
public class PostService implements DefaultService<Post>{
    @Autowired
    private PostRepository repository; 
    
    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> opt = repository.findById(id);
        return opt.get();
    }

    @Override
    public Post save(Post entity) {
        entity.setCreatedAt(LocalDate.now());
        return repository.save(entity);
    }

}
