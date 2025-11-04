package com.kdedevelop.mediani.application.character.port.in.usecase;

import com.kdedevelop.mediani.application.character.port.in.command.CharacterCreateCommand;

public interface CharacterCreateUseCase {
    void create(CharacterCreateCommand command);
}
