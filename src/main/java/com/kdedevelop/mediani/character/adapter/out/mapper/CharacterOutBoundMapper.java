package com.kdedevelop.mediani.character.adapter.out.mapper;

import com.kdedevelop.mediani.character.adapter.out.mybatis.CharacterMyBatisEntity;
import com.kdedevelop.mediani.character.domain.Character;

public class CharacterOutBoundMapper {
    public static Character toCharacter(CharacterMyBatisEntity characterMyBatisEntity) {
        return new Character(characterMyBatisEntity.getId(), characterMyBatisEntity.getName());
    }

    public static CharacterMyBatisEntity toCharacterMyBatisEntity(Character character) {
        return new CharacterMyBatisEntity(character.getId(), character.getName());
    }
}
