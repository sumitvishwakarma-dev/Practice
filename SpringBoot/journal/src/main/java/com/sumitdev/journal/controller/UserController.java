package com.sumitdev.journal.controller;

import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.repository.UserRepository;
import com.sumitdev.journal.services.JournalService;
import com.sumitdev.journal.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/user")
public class UserController {

    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/test-mongo")
    public String testMongo() {
        return "MongoDB connection successful. Database contains "
                + userRepository.count()
                + " documents.";
    }

    @GetMapping()
    public ResponseEntity<?> getUser(){
        List<UserEntity> list = userService.getUser();

        if(list != null && !list.isEmpty()){
            return new ResponseEntity(list, HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> addUser(@RequestBody UserEntity user){
        try {
            UserEntity userList =  userService.addUser(user);
            return new ResponseEntity<>(userList, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserEntity> getJournalById(@PathVariable String username){
        UserEntity response =  userService.getUserByUsername(username);
        if (response != null){
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{username}")
    public ResponseEntity<UserEntity> updateJournal(@PathVariable String username,
                                     @RequestBody UserEntity entity){
        UserEntity response =  userService.updateUserDetails(username, entity);
        if (response !=null)
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteJournal(@PathVariable String username){
        userService.removeUser(username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
