package com.kdedevelop.mediani.application.character.port.out;

import com.kdedevelop.mediani.domain.Character;

import java.util.Optional;

public interface CharacterReadByNamePort {
    Optional<Character> readByName(String name);
}
