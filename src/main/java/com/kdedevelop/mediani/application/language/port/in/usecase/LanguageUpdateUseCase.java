package com.kdedevelop.mediani.application.language.port.in.usecase;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageUpdateCommand;

public interface LanguageUpdateUseCase {
    void update(LanguageUpdateCommand command);
}
