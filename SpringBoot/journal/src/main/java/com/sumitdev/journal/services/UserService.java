package com.sumitdev.journal.services;

import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.repository.JournalRepository;
import com.sumitdev.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
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
