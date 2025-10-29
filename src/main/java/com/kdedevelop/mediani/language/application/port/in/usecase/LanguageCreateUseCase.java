package com.kdedevelop.mediani.language.application.port.in.usecase;

import com.kdedevelop.mediani.language.application.port.in.command.LanguageCreateCommand;

public interface LanguageCreateUseCase {
    void create(LanguageCreateCommand command);
}
