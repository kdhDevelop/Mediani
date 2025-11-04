package com.kdedevelop.mediani.application.language.port.in.usecase;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Language;

public interface LanguageReadOrCreateByNameUseCase {
    Language readOrCreateByName(LanguageReadOrCreateByNameCommand command);
}
