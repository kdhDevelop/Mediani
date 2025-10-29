package com.kdedevelop.mediani.character.application.port.in.usecase;

import com.kdedevelop.mediani.character.application.port.in.command.CharacterCreateCommand;

public interface CharacterCreateUseCase {
    void create(CharacterCreateCommand command);
}
