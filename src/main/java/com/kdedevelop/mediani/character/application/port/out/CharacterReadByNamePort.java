package com.kdedevelop.mediani.character.application.port.out;

import com.kdedevelop.mediani.character.domain.Character;

import java.util.Optional;

public interface CharacterReadByNamePort {
    Optional<Character> readByName(String name);
}
