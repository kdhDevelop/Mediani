package com.kdedevelop.mediani.character.application.port.in.usecase;

import com.kdedevelop.mediani.character.application.port.in.command.CharacterUpdateCommand;

public interface CharacterUpdateUseCase {
    void update(CharacterUpdateCommand command);
}
