package com.example.dndapi.process;


import com.example.dndapi.dto.CharactersCollectionResponseDto;
import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.mapper.DndCharacterDTOMapper;
import com.example.dndapi.repository.DnDCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CharacterProcess {

    private final DnDCharacterRepository characterRepository;
    private final DndCharacterDTOMapper dndCharacterDTOMapper = DndCharacterDTOMapper.INSTANCE;

    public CharacterEntity createCharacter(final DnDCharacterDto character) {
        final CharacterEntity characterEntity = dndCharacterDTOMapper.characterDTOtoCharacterEntity(character);
        return characterRepository.save(characterEntity);
    }

    public List<CharactersCollectionResponseDto> fetchCharacters() {
        return characterRepository.findAll().stream()
                .map(characterEntity -> CharactersCollectionResponseDto.builder()
                        .id(characterEntity.getId())
                        .name(characterEntity.getName())
                        .level(characterEntity.getLevel())
                        .description(characterEntity.getDescription())
                        .build()
                )
                .toList();
    }

    public DnDCharacterDto fetchCharacter(final String id) {
        return characterRepository.findById(id)
                .map(dndCharacterDTOMapper::characterEntityToCharacterDTO)
                .orElse(null);
    }

    public boolean checkExists(final String name) {
        return characterRepository.findByName(name) != null;
    }

    public boolean updateCharacter(final String id, final DnDCharacterDto character) {
        final CharacterEntity characterEntity = dndCharacterDTOMapper.characterDTOtoCharacterEntity(character);
        final Optional<CharacterEntity> currentCharacter = characterRepository.findById(id);

        return currentCharacter.map(CharacterEntity::getId)
                .map(characterId -> characterEntity.toBuilder()
                        .id(characterId)
                        .build())
                .map(characterRepository::save)
                .isPresent();
    }
}