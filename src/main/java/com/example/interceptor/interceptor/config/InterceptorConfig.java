package com.example.interceptor.interceptor.config;

import com.example.interceptor.interceptor.CustomInterceptor;
import com.example.interceptor.interceptor.ProductServiceInterceptor;
import com.example.interceptor.interceptor.UserServiceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        //        thêm interceptor cho user
        registry.addInterceptor(new UserServiceInterceptor()).addPathPatterns("/user/**");
        //        thêm interceptor cho product
        registry.addInterceptor(new ProductServiceInterceptor()).addPathPatterns("/product/**");

        //        interceptor custom cho cả app
        registry.addInterceptor(new CustomInterceptor());
    }
}
