package com.kdedevelop.mediani.language.application.port.in.usecase;

import com.kdedevelop.mediani.language.application.port.in.command.LanguageUpdateCommand;

public interface LanguageUpdateUseCase {
    void update(LanguageUpdateCommand command);
}
