package com.sesac.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);

        registry.addViewController("/").setViewName("/home/home");
        registry.addViewController("/home/home").setViewName("/home/home");
        registry.addViewController("/user/list").setViewName("/user/user_list");
        registry.addViewController("/user/join").setViewName("/user/user_join");
        registry.addViewController("/secure/login").setViewName("/user/secure_login");

    }
}
