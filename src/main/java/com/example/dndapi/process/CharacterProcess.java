package com.example.dndapi.process;


import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.entity.*;
import com.example.dndapi.repository.DnDCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CharacterProcess {
    private final DnDCharacterRepository characterRepository;

    public CharacterEntity createCharacter(final DnDCharacterDto character) {
        final CharacterEntity characterEntity = convert(character);


        return characterRepository.save(characterEntity);
    }

    public List<CharacterEntity> fetchCharacters() {
        return characterRepository.findAll();
    }

    public Optional<CharacterEntity> fetchCharacter(final String id) {
        return characterRepository.findById(id);
    }

    public boolean checkExists(final String name){
        return characterRepository.findByName(name) != null;
    }

    public CharacterEntity updateCharacter(final String id, final DnDCharacterDto character){
        final CharacterEntity characterEntity = convert(character);
        final Optional<CharacterEntity> currentCharacter = characterRepository.findById(id);

        return currentCharacter.map(CharacterEntity::getId)
                .map(characterId->characterEntity.toBuilder().id(characterId).build())
                .map(entity->characterRepository.save(entity)).orElse(null);


    }



    private static CharacterEntity convert(DnDCharacterDto character) {
        final CharacterEntity.CharacterEntityBuilder characterEntityBuilder = CharacterEntity.builder()


                //.skills(character.getSkills())

                .name(character.getName())
                .description(character.getDescription())
                .level(character.getLevel());


        character.getHp().ifPresent(hp->{
            HpEntity hpEntity = HpEntity.builder()
                    .curr_hp(hp.getCurr_hp())
                    .max_hp(hp.getMax_hp())

                    .build();
            characterEntityBuilder.hp(hpEntity);
        });


        //.inventory(character.getInventory())


        character.getSkills().ifPresent(skills->{
            SkillsEntity skillsEntity = SkillsEntity.builder()
                    .strength(skills.getStrength())
                    .dexterity(skills.getDexterity())
                    .constitution(skills.getConstitution())
                    .intelligence(skills.getIntelligence())
                    .wisdom(skills.getWisdom())
                    .charisma(skills.getCharisma())

                    .build();
            characterEntityBuilder.skills(skillsEntity);
        });

        character.getInventory().ifPresent(inventory->{
            InventoryEntity inventoryEntity = InventoryEntity.builder()
                    .weapon(WeaponEntity.builder().weapon_value(inventory.getWeapon().getWeapon_value())
                            .weapon_desc(inventory.getWeapon().getWeapon_desc())
                            .build())

                    .armour(ArmourEntity.builder().armour_class(inventory.getArmour().getArmour_class())
                            .armour_desc(inventory.getArmour().getArmour_desc())
                            .build())

                    .potion(inventory.getPotion())

                    .items(inventory.getItems().stream()
                            .map(inventoryitem->ItemsEntity.builder()
                                    .name(inventoryitem.getName())
                                    .description(inventoryitem.getDescription())
                                    .value(inventoryitem.getValue())
                                    .build()
                            )
                            .toList())
                    .build();
            characterEntityBuilder.inventory(inventoryEntity);
        });
        return characterEntityBuilder.build();
    }


}