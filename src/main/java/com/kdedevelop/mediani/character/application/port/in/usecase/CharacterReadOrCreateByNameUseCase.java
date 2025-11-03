package com.kdedevelop.mediani.character.application.port.in.usecase;

import com.kdedevelop.mediani.character.application.port.in.command.CharacterReadOrCreateByNameCommand;
import com.kdedevelop.mediani.character.domain.Character;

public interface CharacterReadOrCreateByNameUseCase {
    Character readOrCreateByName(CharacterReadOrCreateByNameCommand command);
}
