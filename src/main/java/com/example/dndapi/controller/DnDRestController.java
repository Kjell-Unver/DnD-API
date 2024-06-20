package com.example.dndapi.controller;

import com.example.dndapi.dto.*;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.entity.HpEntity;
import com.example.dndapi.entity.InventoryEntity;
import com.example.dndapi.process.CharacterProcess;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

// new imports
import java.util.List;
import java.util.Optional;

@CrossOrigin
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
        final boolean characterExistsBool = characterProcess.checkExists(character.getName());

        if(characterExistsBool){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Character already exists");
        }

        CharacterEntity characterEntity = characterProcess.createCharacter(character);


        final CreateCharacterResponseDto responseBody = new CreateCharacterResponseDto(characterEntity.getId());

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CharactersCollectionResponseDto>> getCharacters() {

        final List<CharactersCollectionResponseDto> collectionResponseList = characterProcess.fetchCharacters().stream()
                .map(characterEntity -> CharactersCollectionResponseDto.builder()
                        .id(characterEntity.getId())
                        .name(characterEntity.getName())
                        .level(characterEntity.getLevel())
                        .description(characterEntity.getDescription())
                        .build()
                ).toList();
        return ResponseEntity.ok(collectionResponseList);
    }


    @GetMapping(value = "/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CharacterResponseDto> getCharacter(@PathVariable final String id) {

        Optional<CharacterResponseDto> characterResponseDto = characterProcess.fetchCharacter(id)
                .map(characterEntity -> CharacterResponseDto.builder()
                        .id(characterEntity.getId())
                        .name(characterEntity.getName())
                        .level(characterEntity.getLevel())
                        .description(characterEntity.getDescription())


                        .hp(Optional.ofNullable(characterEntity.getHp())
                                .map(hpEntity -> HpDto.builder()
                                        .max_hp(hpEntity.getMax_hp())
                                        .curr_hp(hpEntity.getCurr_hp())
                                        .build()
                                ).orElse(null))


                        .skills(Optional.ofNullable(characterEntity.getSkills())
                                .map(skillsEntity -> SkillsDto.builder()
                                        .strength(skillsEntity.getStrength())
                                        .dexterity(skillsEntity.getDexterity())
                                        .constitution(skillsEntity.getConstitution())
                                        .intelligence(skillsEntity.getIntelligence())
                                        .wisdom(skillsEntity.getWisdom())
                                        .charisma(skillsEntity.getCharisma())
                                        .build()
                                ).orElse(null))


                        .inventory(Optional.ofNullable(characterEntity.getInventory())
                                .map(inventoryEntity -> InventoryDto.builder()

                                        .potion(inventoryEntity.getPotion())

                                        .armour(Optional.ofNullable(inventoryEntity.getArmour())
                                                .map(armourEntity -> ArmourDto.builder()
                                                        .armour_class(armourEntity.getArmour_class())
                                                        .armour_desc(armourEntity.getArmour_desc())
                                                        .build()
                                                ).orElse(null))


                                        .weapon(Optional.ofNullable(inventoryEntity.getWeapon())
                                                .map(weaponEntity -> WeaponDto.builder()
                                                        .weapon_desc(weaponEntity.getWeapon_desc())
                                                        .weapon_value(weaponEntity.getWeapon_value())
                                                        .build()
                                                ).orElse(null))

                                        .items(inventoryEntity.getItems().stream()
                                                .map(itemsEntity -> ItemsDto.builder()
                                                        .name(itemsEntity.getName())
                                                        .value(itemsEntity.getValue())
                                                        .description(itemsEntity.getDescription())
                                                        .build()
                                                ).toList())


                                        .build()
                                ).orElse(null))


                        .build()
                );

        if (characterResponseDto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(characterResponseDto.get());
    }


    @PutMapping(value = "/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateCharacter(@RequestBody DnDCharacterDto character, @PathVariable final String id) {


        CharacterEntity updated = characterProcess.updateCharacter(id, character);

        return updated != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }





}