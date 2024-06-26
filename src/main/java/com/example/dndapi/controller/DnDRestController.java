package com.example.dndapi.controller;

import com.example.dndapi.dto.CharactersCollectionResponseDto;
import com.example.dndapi.dto.CreateCharacterResponseDto;
import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.process.CharacterProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DnDRestController {

    private final CharacterProcess characterProcess;

    @PostMapping(
            value = "/character",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateCharacterResponseDto> createCharacter(@RequestBody DnDCharacterDto character) {
        final boolean characterExistsBool = characterProcess.checkExists(character.getName());

        if (characterExistsBool) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character already exists");
        }

        CharacterEntity characterEntity = characterProcess.createCharacter(character);

        final CreateCharacterResponseDto responseBody = new CreateCharacterResponseDto(characterEntity.getId());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CharactersCollectionResponseDto>> getCharacters() {
        final List<CharactersCollectionResponseDto> collectionResponseList = characterProcess.fetchCharacters();
        return ResponseEntity.ok(collectionResponseList);
    }


    @GetMapping(value = "/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DnDCharacterDto> getCharacter(@PathVariable final String id) {

        final DnDCharacterDto characterResponseDto = characterProcess.fetchCharacter(id);

        if (characterResponseDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(characterResponseDto);
    }


    @PutMapping(value = "/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateCharacter(@RequestBody DnDCharacterDto character, @PathVariable final String id) {

        boolean updated = characterProcess.updateCharacter(id, character);

        return updated ? ResponseEntity.ok()
                .build() : ResponseEntity.badRequest()
                       .build();
    }


}