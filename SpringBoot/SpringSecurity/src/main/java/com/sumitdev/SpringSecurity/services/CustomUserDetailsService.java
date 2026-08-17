package com.sumitdev.SpringSecurity.services;

import com.sumitdev.SpringSecurity.model.CustomUserDetails;
import com.sumitdev.SpringSecurity.model.User;
import com.sumitdev.SpringSecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(()->
                        new UsernameNotFoundException("Username not found")
                );

        return new CustomUserDetails(user);
    }
}
