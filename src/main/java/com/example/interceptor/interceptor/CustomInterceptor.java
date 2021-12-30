package com.example.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {
    /*sử dụng để thực hiện các operations trước khi gửi request tới Controller. Method này trả về true rồi trả response cho Client.*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[Custom]" + "[preHandle]" + "[" + request.getMethod() +"]");
        return true;
    }

    /*sử dụng để thực hiện các operations trước khi gửi request tới Client*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[Custom]" + "[postHandle][" + request.getRequestURI() + "]");
    }

    /*sử dụng để thực hiện các operations sau khi hoàn thành việc gửi request và response.*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            ex.printStackTrace();
        }
        log.info("[Custom]" + "[afterCompletion][" + request.getPathInfo() + "][exception: " + ex + "]");
    }
}
