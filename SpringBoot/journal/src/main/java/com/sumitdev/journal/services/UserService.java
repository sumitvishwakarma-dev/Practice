package com.sumitdev.journal.services;

import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.repository.JournalRepository;
import com.sumitdev.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public UserEntity addUser(UserEntity user) {
        UserEntity userPresent = getUserByUsername(user.getUsername());
        if (userPresent == null) {
            userPresent.setPassword(passwordEncoder.encode(userPresent.getPassword()));
            userPresent.setRoles(Arrays.asList("USER"));
            return userRepository.save(userPresent);
        }
        else
            return userPresent;
    }

    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }

    public UserEntity getUserByUsername(String username) {
        Optional<UserEntity> op = userRepository.findByUsername(username);
        return op.get();
    }

    public UserEntity updateUserDetails(String username, UserEntity entity) {

        Optional<UserEntity> user = userRepository.findByUsername(username);
        UserEntity userEntity = user.get();

        if(userEntity != null){

            userEntity.setPassword(!entity.getPassword().equals("") ? entity.getPassword() : userEntity.getPassword());

        }
       return userRepository.save(userEntity);
    }

    public void removeUser(String username) {
         userRepository.deleteByUsername(username);
    }
}
