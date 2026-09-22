package com.sumitdev.journal.repository;

import com.sumitdev.journal.entity.JournalEntity;
import com.sumitdev.journal.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {

    Optional<UserEntity> findByUsername(String username);

    void deleteByUsername(String username);

}
