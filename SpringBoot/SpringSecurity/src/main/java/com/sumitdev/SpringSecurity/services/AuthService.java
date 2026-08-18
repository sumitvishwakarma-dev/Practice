package com.sumitdev.SpringSecurity.services;

import com.sumitdev.SpringSecurity.dto.UserRegisterRequestDto;
import com.sumitdev.SpringSecurity.dto.UserRegisterResponseDto;
import com.sumitdev.SpringSecurity.model.Role;
import com.sumitdev.SpringSecurity.model.User;
import com.sumitdev.SpringSecurity.repository.RoleRepository;
import com.sumitdev.SpringSecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    AuthService(UserRepository userRepository,
                RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {

        Optional<User> userFind = userRepository.findByUsername(userRegisterRequestDto.getUsername());

        if(!userFind.isEmpty()){
             throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(userRegisterRequestDto.getUsername());

        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();

        userRegisterResponseDto.setUsername(userRegisterRequestDto.getUsername());
        userRegisterResponseDto.setMessage("User registered Successfully");

        return userRegisterResponseDto;
    }
}
