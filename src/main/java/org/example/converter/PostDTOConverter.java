package org.example.converter;

import org.example.domain.Post;
import org.example.dto.PostDTO;
import org.example.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDTOConverter implements Converter<String, PostDTO> {

    @Autowired
    private PostRepo postRepo;


    @Override
    public PostDTO convert(String source) {
        Long postId = Long.parseLong(source);
        Post post = postRepo.findById(postId).get();

        PostDTO postDTO = new PostDTO();
        postDTO.setAuthorId(post.getAuthor().getId());
        postDTO.setContent(post.getContent());

        return postDTO;
    }
}
