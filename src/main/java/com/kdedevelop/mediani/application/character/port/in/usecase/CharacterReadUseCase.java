package com.kdedevelop.mediani.application.character.port.in.usecase;

import com.kdedevelop.mediani.application.character.port.in.command.CharacterReadCommand;
import com.kdedevelop.mediani.domain.Character;

public interface CharacterReadUseCase {
    Character read(CharacterReadCommand command);
}
