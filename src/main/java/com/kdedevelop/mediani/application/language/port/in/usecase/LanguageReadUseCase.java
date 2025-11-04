package com.kdedevelop.mediani.application.language.port.in.usecase;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageReadCommand;
import com.kdedevelop.mediani.domain.Language;

public interface LanguageReadUseCase {
    Language read(LanguageReadCommand command);
}
