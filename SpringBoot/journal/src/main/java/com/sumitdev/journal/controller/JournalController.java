package com.sumitdev.journal.controller;

import com.sumitdev.journal.JournalApplication;
import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.repository.UserRepository;
import com.sumitdev.journal.services.JournalService;
import com.sumitdev.journal.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/app/journal/")
public class JournalController {

    private JournalService journalService;

    private UserService userService;

    JournalController(JournalService journalService,
                      UserService userService){
        this.journalService = journalService;
        this.userService = userService;
    }

    @GetMapping("{username}")
    public ResponseEntity<?> getJournal(@PathVariable String username){
        UserEntity user = userService.getUserByUsername(username);

        List<JournalEntity> list = user.getJournalEntityList();

        if(list != null && !list.isEmpty()){
            return new ResponseEntity(list, HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{username}")
    public ResponseEntity<?> saveJournal(@RequestBody JournalEntity journal,
                                         @PathVariable String username){
        try {
            journalService.saveJournal(journal, username);
            return new ResponseEntity<>(journal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable ObjectId myId){
        JournalEntity response =  journalService.getJournalById(myId);
        if (response != null){
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{username}/{myId}")
    public ResponseEntity<JournalEntity> updateJournal(@PathVariable ObjectId myId,
                                                       @RequestBody JournalEntity entity,
                                                       @PathVariable String username){
        JournalEntity response =  journalService.updateJournal(myId, entity);
        if (response !=null)
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{username}/{myId}")
    public ResponseEntity deleteJournal(@PathVariable ObjectId myId, @PathVariable String username){
        journalService.removeJournal(myId , username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
