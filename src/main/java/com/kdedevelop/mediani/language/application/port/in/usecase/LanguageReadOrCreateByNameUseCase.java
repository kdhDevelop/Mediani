package com.kdedevelop.mediani.language.application.port.in.usecase;

import com.kdedevelop.mediani.language.application.port.in.command.LanguageReadOrCreateByNameCommand;
import com.kdedevelop.mediani.language.domain.Language;

public interface LanguageReadOrCreateByNameUseCase {
    Language readOrCreateByName(LanguageReadOrCreateByNameCommand command);
}
