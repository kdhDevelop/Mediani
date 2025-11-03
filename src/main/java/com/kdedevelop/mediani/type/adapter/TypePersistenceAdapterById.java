package com.kdedevelop.mediani.type.adapter;

import com.kdedevelop.mediani.type.adapter.out.mapper.TypeOutBoundMapper;
import com.kdedevelop.mediani.type.adapter.out.mybatis.TypeMyBatisEntity;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.ShortIdGenerator;
import com.kdedevelop.mediani.type.adapter.out.mybatis.TypeMyBatisRepository;
import com.kdedevelop.mediani.type.application.port.out.*;
import com.kdedevelop.mediani.type.domain.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypePersistenceAdapterById implements TypeCreatePort, TypeReadByIdPort, TypeReadByNamePort, TypeSearchByNameContainedPort, TypeGenerateIdPort, TypeUpdatePort, TypeDeletePort {
    private final TypeMyBatisRepository typeMyBatisRepository;
    private final ShortIdGenerator idGenerator;

    public TypePersistenceAdapterById(@Autowired TypeMyBatisRepository typeMyBatisRepository) {
        this.typeMyBatisRepository = typeMyBatisRepository;

        Optional<TypeMyBatisEntity> entity = typeMyBatisRepository.readFirstByOrderByIdDesc();
        this.idGenerator = new ShortIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Type type) {
        TypeMyBatisEntity typeMyBatisEntity = TypeOutBoundMapper.toTypeMyBatisEntity(type);
        typeMyBatisRepository.create(typeMyBatisEntity);
    }

    @Override
    public short generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Type> readById(short id) {
        return typeMyBatisRepository.readById(id).map(TypeOutBoundMapper::toType);
    }

    @Override
    public Optional<Type> readByName(String name) {
        return typeMyBatisRepository.readByName(name).map(TypeOutBoundMapper::toType);
    }

    @Override
    public Page<Type> searchByNameContained(String name, Pageable pageable) {
        short totalElementCount = typeMyBatisRepository.countAll();
        List<TypeMyBatisEntity> result = typeMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(TypeOutBoundMapper::toType).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Type type) {
        TypeMyBatisEntity typeMyBatisEntity = TypeOutBoundMapper.toTypeMyBatisEntity(type);
        typeMyBatisRepository.update(typeMyBatisEntity);
    }

    @Override
    public void delete(short id) {
        typeMyBatisRepository.delete(id);
    }
}
