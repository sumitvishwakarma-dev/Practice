package com.sumitdev.journal.controller;

import com.sumitdev.journal.JournalApplication;
import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.services.JournalService;
import org.bson.types.ObjectId;
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

    // Map<Long, JournalEntity> journalEntity = new HashMap<>();

    @GetMapping()
    public List<JournalEntity> getJournal(){
        return journalService.getJournal();
    }

    @PostMapping()
    public JournalEntity saveJournal(@RequestBody JournalEntity journal){
        return journalService.saveJournal(journal);
    }

    @GetMapping("/id/{myId}")
    public JournalEntity getJournalById(@PathVariable ObjectId myId){
        return journalService.getJournalById(myId);
    }

    @PutMapping("/id/{myId}")
    public JournalEntity updateJournal(@PathVariable ObjectId myId,
                                     @RequestBody JournalEntity entity){
        return journalService.updateJournal(myId, entity);
    }

    @DeleteMapping("/{myId}")
    public void deleteJournal(@PathVariable ObjectId myId){
        journalService.removeJournal(myId);
    }



}
