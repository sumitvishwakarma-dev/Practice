package com.example.demoFilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        String token = servletRequest.getHeader("token");

       if (!token.equals("12345") || token == null){
           servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           servletResponse.getWriter().write(
                   "{\n" +
                           "    \"message\":\"User is unauthorized\"\n" +
                           "}"
           );
           servletResponse.setContentType("application/json");
           return;
       }

       chain.doFilter(request,response);

    }
}
