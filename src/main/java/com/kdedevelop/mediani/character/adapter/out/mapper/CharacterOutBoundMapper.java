package com.kdedevelop.mediani.character.adapter.out.mapper;

import com.kdedevelop.mediani.character.adapter.out.mongo.CharacterMongoEntity;
import com.kdedevelop.mediani.character.domain.Character;

public class CharacterOutBoundMapper {
    public static Character toCharacter(CharacterMongoEntity characterMongoEntity) {
        return new Character(characterMongoEntity.getId(), characterMongoEntity.getName());
    }

    public static CharacterMongoEntity toCharacterMongoEntity(Character character) {
        return new CharacterMongoEntity(character.getId(), character.getName());
    }
}
