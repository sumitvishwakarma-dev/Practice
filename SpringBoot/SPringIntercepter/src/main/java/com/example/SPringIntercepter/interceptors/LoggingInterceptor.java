package com.example.SPringIntercepter.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class LoggingInterceptor  implements HandlerInterceptor {

    public boolean preHandle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object obj
    ){


        String URI = httpServletRequest.getRequestURI();
        System.out.println("URI: "+URI);

        String method = httpServletRequest.getMethod();
        System.out.println("Method: "+method);

        String uUID = UUID.randomUUID().toString();

        httpServletResponse.setHeader("x-access-apiRequest-ID",uUID);

        return true;
    }

}
