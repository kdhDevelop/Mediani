package com.kdedevelop.mediani.language.adapter.out.mapper;

import com.kdedevelop.mediani.language.adapter.out.mongo.LanguageMongoEntity;
import com.kdedevelop.mediani.language.domain.Language;

public class LanguageOutBoundMapper {
    public static Language toLanguage(LanguageMongoEntity languageMongoEntity) {
        return new Language(languageMongoEntity.getId(), languageMongoEntity.getName());
    }

    public static LanguageMongoEntity toLanguageMongoEntity(Language language) {
        return new LanguageMongoEntity(language.getId(), language.getName());
    }
}
