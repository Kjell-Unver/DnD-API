package com.example.dndapi.controller;

import com.example.dndapi.process.CharacterProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// new imports
import org.springframework.util.StreamUtils;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import java.nio.charset.StandardCharsets;
import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.dto.CreateCharacterResponseDto;

@RestController
@RequiredArgsConstructor
public class DnDRestController {

private final CharacterProcess characterProcess;
//
//    // http://localhost:8080/character?uuid=1832-fa13-524d-424g
//    @GetMapping("/character")
//    String getUuid(@RequestParam String uuid) {
//
//        System.out.println(uuid);
//        return uuid;
//    }
//
//
//
//
//    @GetMapping("/json")
//    String jsonFile() throws IOException {
//
//        ClassPathResource jsonFile = new ClassPathResource("data/characters.json");
//
//        String content = StreamUtils.copyToString(jsonFile.getInputStream(), StandardCharsets.UTF_8);
//
//        return content;
//    }






    @PostMapping(value = "/character", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreateCharacterResponseDto> createCharacter(@RequestBody DnDCharacterDto character) {

        System.out.println("Works");
        final CreateCharacterResponseDto responseBody = new CreateCharacterResponseDto("dfgafw-443224-fgaggwgw-42141");

        characterProcess.createCharacter(character);

        return ResponseEntity.ok(responseBody);
    }




}