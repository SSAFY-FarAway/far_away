package com.ssafy.faraway.common.config;

import com.ssafy.faraway.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/",
                        "/login",
                        "/sign-up",
                        "/find",
                        "/member/login",
                        "/member/login-pwd",
                        "/member/login-id",
                        "/member/sign-up",
                        "/search_place",
                        "/attraction/**",
                        "/plan-list",
                        "/hotplace-list",
                        "/post-list",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/resources/static/**",
                        "/v2/api-docs");
    }
}
