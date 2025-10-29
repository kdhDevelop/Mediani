package com.kdedevelop.mediani.character.application.port.in.usecase;

import com.kdedevelop.mediani.character.application.port.in.command.CharacterReadCommand;
import com.kdedevelop.mediani.character.domain.Character;

public interface CharacterReadUseCase {
    Character read(CharacterReadCommand command);
}
