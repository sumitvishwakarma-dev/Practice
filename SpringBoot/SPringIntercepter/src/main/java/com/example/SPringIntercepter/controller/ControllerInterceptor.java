package com.example.SPringIntercepter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interceptor")
public class ControllerInterceptor {

    @GetMapping
    public void call(){
        System.out.println("com/example/SPringIntercepter/controller");
    }

}
