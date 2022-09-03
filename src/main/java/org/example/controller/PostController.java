package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Post;
import org.example.dto.PostDTO;
import org.example.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post")
@Slf4j
public class PostController {

    @Autowired
    private PostRepo postRepo;

    @PostMapping
    public Post savePost(
            Post post
    ) {
        Post savedPost = postRepo.save(post);
        log.info("Saved post : {{}}", savedPost);
        return savedPost;
    }

    @GetMapping("/simple/{id}")
    private PostDTO getPostDTOById(
            @PathVariable("id") PostDTO postDTO
    ) {
        return postDTO;
    }

}
