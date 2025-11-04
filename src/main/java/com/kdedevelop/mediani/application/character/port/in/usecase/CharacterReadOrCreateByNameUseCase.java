package com.kdedevelop.mediani.application.character.port.in.usecase;

import com.kdedevelop.mediani.application.character.port.in.command.CharacterReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Character;

public interface CharacterReadOrCreateByNameUseCase {
    Character readOrCreateByName(CharacterReadOrCreateByNameCommand command);
}
