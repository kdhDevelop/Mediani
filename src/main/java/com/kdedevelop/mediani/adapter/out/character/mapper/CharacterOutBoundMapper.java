package com.kdedevelop.mediani.adapter.out.character.mapper;

import com.kdedevelop.mediani.adapter.out.character.mybatis.CharacterMyBatisEntity;
import com.kdedevelop.mediani.domain.Character;

public class CharacterOutBoundMapper {
    public static Character toCharacter(CharacterMyBatisEntity characterMyBatisEntity) {
        return new Character(characterMyBatisEntity.getId(), characterMyBatisEntity.getName());
    }

    public static CharacterMyBatisEntity toCharacterMyBatisEntity(Character character) {
        return new CharacterMyBatisEntity(character.getId(), character.getName());
    }
}
