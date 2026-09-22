package com.sumitdev.journal.controller;

import com.sumitdev.journal.JournalApplication;
import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.services.JournalService;
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

    JournalController(JournalService journalService){
        this.journalService = journalService;
    }

    @GetMapping()
    public ResponseEntity<?> getJournal(){
        List<JournalEntity> list = journalService.getJournal();

        if(list != null && !list.isEmpty()){
            return new ResponseEntity(list, HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> saveJournal(@RequestBody JournalEntity journal){
        try {
            JournalEntity journal1 =  journalService.saveJournal(journal);
            return new ResponseEntity<>(journal1, HttpStatus.CREATED);
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

    @PutMapping("/id/{myId}")
    public ResponseEntity<JournalEntity> updateJournal(@PathVariable ObjectId myId,
                                     @RequestBody JournalEntity entity){
        JournalEntity response =  journalService.updateJournal(myId, entity);
        if (response !=null)
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{myId}")
    public ResponseEntity deleteJournal(@PathVariable ObjectId myId){
        journalService.removeJournal(myId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
