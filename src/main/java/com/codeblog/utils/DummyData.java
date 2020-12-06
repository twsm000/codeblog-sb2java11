package com.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codeblog.model.Post;
import com.codeblog.repository.PostRepository;

@Component
public class DummyData {
    @Autowired
    private PostRepository postRepo;

    //@PostConstruct
    public void savePosts() {
        List<Post> postList = new ArrayList<>();
        Post p1 = new Post();
        p1.setAuthor("Thomas M.");
        p1.setCreatedAt(LocalDate.now());
        p1.setTitle("Docker");
        p1.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque leo mi, sodales ut massa eget, facilisis hendrerit quam. Aliquam tempor interdum massa vitae venenatis. Praesent sit amet semper augue, at euismod nulla. Nulla congue lacinia magna, non pretium nisl semper eu. Curabitur pellentesque at dui id interdum. Nam sit amet finibus nunc, tempus accumsan risus. Vestibulum placerat sem ac nisl consequat vestibulum.");

        Post p2 = new Post();
        p2.setAuthor("Thomas M.");
        p2.setCreatedAt(LocalDate.now());
        p2.setTitle("API REST");
        p2.setText(
                "Proin ultricies augue augue, eu mattis tellus gravida in. In iaculis nunc sit amet venenatis tristique. Integer dui quam, mattis id augue congue, commodo volutpat risus. Praesent erat dui, rhoncus vitae laoreet a, lacinia facilisis nisi. Nunc congue nulla et aliquam mollis. Etiam molestie velit quis metus tempus, non viverra mauris interdum. Phasellus iaculis metus vulputate pretium consequat. Donec a justo quis erat fermentum convallis vel vel elit. Aliquam erat volutpat. Donec quis augue sit amet leo placerat congue non ut tortor. Integer et tellus fringilla mi dictum ultrices et non purus. Etiam in arcu a leo venenatis viverra convallis id ante. In hac habitasse platea dictumst. Maecenas tincidunt eget lectus at commodo. Nam congue vestibulum sapien eget accumsan. Duis ultricies nunc eu turpis consequat, et posuere dolor placerat.");
        
        Post p3 = new Post();
        p3.setAuthor("Thomas M.");
        p3.setCreatedAt(LocalDate.now());
        p3.setTitle("Springboot API");
        p3.setText(
                "Aliquam tempor neque ut nibh varius suscipit non mattis erat. Morbi maximus ornare massa, ut aliquam sapien aliquam at. In mi metus, ultricies eget justo eu, semper rutrum sem. Nam sed pretium odio. Nam facilisis ligula et consectetur tincidunt. Aenean id mi cursus, bibendum metus vitae, blandit tortor. Morbi iaculis feugiat sem in placerat. Nulla facilisi. Nullam sed pharetra augue. Nullam feugiat ipsum vitae dui tincidunt, eget molestie justo maximus. Fusce sed turpis sed diam iaculis lobortis. Aliquam erat volutpat. Ut vel eros nisi. Quisque hendrerit posuere tempus.");        
        
        postList.add(p1);
        postList.add(p2);
        postList.add(p3);
        
        for (Post post : postList) {
            Post saved = postRepo.save(post);
            System.out.println("Post created: " + saved.getId());
        }
    }
}
