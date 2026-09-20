package com.sumitdev.journal.controller;

import com.sumitdev.journal.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/journal/")
public class JournalController {

    Map<Long, JournalEntity> journalEntity = new HashMap<>();

    @GetMapping()
    public List<JournalEntity> getJournal(){
        return new ArrayList<>(journalEntity.values());
    }

    @PostMapping()
    public boolean saveJournal(@RequestBody JournalEntity journal){
        journalEntity.put(journal.getId(), journal );
        return true;
    }

}
