package com.example.SPringIntercepter.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.UUID;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

    public boolean preHandle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object obj
    ) throws IOException {
        String token = httpServletRequest.getHeader("token");
        if (token == null || !token.equals("secret123")){

            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\":\"Unauthorised Access\"\n" +
                            "}"
            );
        }
        return true;
    }

}
