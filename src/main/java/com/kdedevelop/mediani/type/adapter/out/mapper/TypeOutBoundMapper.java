package com.kdedevelop.mediani.type.adapter.out.mapper;

import com.kdedevelop.mediani.type.adapter.out.mongo.TypeMongoEntity;
import com.kdedevelop.mediani.type.domain.Type;

public class TypeOutBoundMapper {
    public static Type toType(TypeMongoEntity typeMongoEntity) {
        return new Type(typeMongoEntity.getId(), typeMongoEntity.getName());
    }

    public static TypeMongoEntity toTypeJpaEntity(Type type) {
        return new TypeMongoEntity(type.getId(), type.getName());
    }
}
