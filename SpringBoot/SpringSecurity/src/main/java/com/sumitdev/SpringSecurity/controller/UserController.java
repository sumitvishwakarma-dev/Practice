package com.sumitdev.SpringSecurity.controller;

import com.sumitdev.SpringSecurity.dto.UserRegisterRequestDto;
import com.sumitdev.SpringSecurity.dto.UserRegisterResponseDto;
import com.sumitdev.SpringSecurity.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private AuthService authService;

    UserController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello(Authentication authentication){
        return "Hello, you are successfully logged in " + authentication.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){

        UserRegisterResponseDto userRegisterResponseDto= authService.register(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);

    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
