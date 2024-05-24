package com.example.dndapi.process;


import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.repository.DnDCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CharacterProcess {
    private final DnDCharacterRepository characterRepository;

    public void createCharacter(final DnDCharacterDto character) {
        final CharacterEntity characterEntity = CharacterEntity.builder()


                .skills(character.getSkills())
                .name(character.getName())
                .description(character.getDescription())
                .level(character.getLevel())

                .hp(character.getHp())

                .inventory(character.getInventory())



                .build();

        characterRepository.save(characterEntity);
    }
}


// Mongo db / jdbc in spring
