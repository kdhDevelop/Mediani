package com.kdedevelop.mediani.language.application.port.in.usecase;

import com.kdedevelop.mediani.language.application.port.in.command.LanguageReadCommand;
import com.kdedevelop.mediani.language.domain.Language;

public interface LanguageReadUseCase {
    Language read(LanguageReadCommand command);
}
