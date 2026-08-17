package com.sumitdev.SpringSecurity.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterRequestDto {

    private String username;

    private String password;
}
