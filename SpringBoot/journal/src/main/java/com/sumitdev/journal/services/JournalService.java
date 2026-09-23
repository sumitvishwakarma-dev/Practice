package com.sumitdev.journal.services;

import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.entity.UserEntity;
import com.sumitdev.journal.repository.JournalRepository;
import com.sumitdev.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private JournalRepository journalRepository;

    private UserService userService;

    JournalService(JournalRepository journalRepository,
                   UserService userService){
        this.journalRepository = journalRepository;
        this.userService=userService;
    }

    public void saveJournal(JournalEntity journal,String username) {
        UserEntity user = userService.getUserByUsername(username);
        journal.setLocaldate(LocalDateTime.now());
        JournalEntity journalSave = journalRepository.save(journal);
        user.getJournalEntityList().add(journalSave);
        userService.addUser(user);
    }

    public List<JournalEntity> getJournal() {
        return journalRepository.findAll();
    }

    public JournalEntity getJournalById(ObjectId myId) {
        Optional<JournalEntity> op = journalRepository.findById(myId);
        return op.get();
    }

    public JournalEntity updateJournal(ObjectId myId, JournalEntity entity) {

        JournalEntity journal = journalRepository.findById(myId).orElse(null);

        if(journal != null){
            journal.setTitle(entity.getTitle() != null && !entity.getTitle().equals("") ? entity.getTitle() : journal.getTitle());
            journal.setContent(entity.getContent() != null && ! entity.getContent().equals("") ? entity.getContent() : journal.getContent());
            journal.setLocaldate(LocalDateTime.now());

        }
       return journalRepository.save(journal);
    }

    public void removeJournal(ObjectId myId) {
         journalRepository.deleteById(myId);
    }
}
