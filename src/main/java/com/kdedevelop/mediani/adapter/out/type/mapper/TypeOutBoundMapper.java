package com.kdedevelop.mediani.adapter.out.type.mapper;

import com.kdedevelop.mediani.adapter.out.type.mybatis.TypeMyBatisEntity;
import com.kdedevelop.mediani.domain.Type;

public class TypeOutBoundMapper {
    public static Type toType(TypeMyBatisEntity typeMyBatisEntity) {
        return new Type(typeMyBatisEntity.getId(), typeMyBatisEntity.getName());
    }

    public static TypeMyBatisEntity toTypeMyBatisEntity(Type type) {
        return new TypeMyBatisEntity(type.getId(), type.getName());
    }
}
