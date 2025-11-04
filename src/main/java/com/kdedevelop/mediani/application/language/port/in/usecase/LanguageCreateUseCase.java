package com.kdedevelop.mediani.application.language.port.in.usecase;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageCreateCommand;

public interface LanguageCreateUseCase {
    void create(LanguageCreateCommand command);
}
