package com.example.dndapi.repository;

import com.example.dndapi.entity.CharacterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DnDCharacterRepository extends MongoRepository<CharacterEntity, String> {
    CharacterEntity findByName(final String name);
}

