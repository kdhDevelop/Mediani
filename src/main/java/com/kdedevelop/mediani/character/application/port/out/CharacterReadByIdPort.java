package com.kdedevelop.mediani.character.application.port.out;

import com.kdedevelop.mediani.character.domain.Character;

public interface CharacterReadByIdPort {
    Character read(long id);
}
