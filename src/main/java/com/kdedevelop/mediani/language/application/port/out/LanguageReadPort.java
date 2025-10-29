package com.kdedevelop.mediani.language.application.port.out;

import com.kdedevelop.mediani.language.domain.Language;

public interface LanguageReadPort {
    Language read(short id);
}
