package com.SG.Configuration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class CorsInterceptor extends HandlerInterceptorAdapter{
    
    public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    public static final String METHODS_NAME = "Access-Control-Allow-Methods";
    public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    public static final String MAX_AGE_NAME = "Access-Control-Max-Age";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader(CREDENTIALS_NAME, "true");
        response.setHeader(ORIGIN_NAME, "http://127.0.0.1:59274");
        response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept, Access-Control-Allow-Credentials");
        response.setHeader(MAX_AGE_NAME, "3600");
        return true;
    }
 
    
}