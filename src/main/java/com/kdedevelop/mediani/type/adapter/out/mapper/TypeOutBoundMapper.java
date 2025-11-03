package com.kdedevelop.mediani.type.adapter.out.mapper;

import com.kdedevelop.mediani.type.adapter.out.mybatis.TypeMyBatisEntity;
import com.kdedevelop.mediani.type.domain.Type;

public class TypeOutBoundMapper {
    public static Type toType(TypeMyBatisEntity typeMyBatisEntity) {
        return new Type(typeMyBatisEntity.getId(), typeMyBatisEntity.getName());
    }

    public static TypeMyBatisEntity toTypeMyBatisEntity(Type type) {
        return new TypeMyBatisEntity(type.getId(), type.getName());
    }
}
