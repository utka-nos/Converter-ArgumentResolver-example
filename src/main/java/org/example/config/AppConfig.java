package org.example.config;

import org.example.resolver.PostBodyArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private PostBodyArgumentResolver postBodyArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(postBodyArgumentResolver);
    }

    //Можно и так добавить конвертер, если не надо, чтобы он был бином
    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PostDTOConverter());
    }*/
}
