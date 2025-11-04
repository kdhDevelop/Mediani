package com.kdedevelop.mediani.application.character.port.in.usecase;

import com.kdedevelop.mediani.application.character.port.in.command.CharacterUpdateCommand;

public interface CharacterUpdateUseCase {
    void update(CharacterUpdateCommand command);
}
