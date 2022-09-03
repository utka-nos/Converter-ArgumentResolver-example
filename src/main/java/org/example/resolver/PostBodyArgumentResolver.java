package org.example.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.annotations.PostBody;
import org.example.domain.Post;
import org.example.domain.User;
import org.example.repo.UserRepo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PostBodyArgumentResolver implements HandlerMethodArgumentResolver {

    private UserRepo userRepo;
    private ObjectMapper objectMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PostBody.class) != null || parameter.getParameterType().equals(Post.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception
    {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String requestBody = request.getReader().lines().collect(Collectors.joining());

        Post post = objectMapper.readValue(requestBody, Post.class);
        Map<String, Object> paramsMap = objectMapper.readValue(requestBody, HashMap.class);

        Long author_id = Long.parseLong(String.valueOf(paramsMap.get("author_id")));
        //Для упрощения не рассматриваем неконсистентные запросы
        User user = userRepo.findById(author_id).get();

        post.setAuthor(user);

        return post;
    }
}
