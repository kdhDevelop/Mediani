package com.kdedevelop.mediani.type.adapter;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.ShortIdGenerator;
import com.kdedevelop.mediani.infrastructure.adapter.out.repository.InMemoryRepository;
import com.kdedevelop.mediani.type.adapter.out.mongo.TypeMongoEntity;
import com.kdedevelop.mediani.type.adapter.out.mongo.TypeMongoRepository;
import com.kdedevelop.mediani.type.adapter.out.mapper.TypeOutBoundMapper;
import com.kdedevelop.mediani.type.application.port.out.*;
import com.kdedevelop.mediani.type.domain.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypePersistenceAdapter implements TypeCreatePort, TypeReadPort, TypeSearchByNameContainedPort, TypeGenerateIdPort, TypeUpdatePort, TypeDeletePort {
    private final TypeMongoRepository typeMongoRepository;
    private final InMemoryRepository<Short, Type> typeInMemoryRepository;
    private final ShortIdGenerator idGenerator;

    public TypePersistenceAdapter(@Autowired TypeMongoRepository typeMongoRepository) {
        this.typeMongoRepository = typeMongoRepository;
        this.typeInMemoryRepository = new InMemoryRepository<>();

        List<TypeMongoEntity> all = typeMongoRepository.findAll();
        for (TypeMongoEntity typeMongoEntity : all) {
            Type type = TypeOutBoundMapper.toType(typeMongoEntity);
            typeInMemoryRepository.add(type.getId(), type);
        }

        Optional<TypeMongoEntity> entity = typeMongoRepository.findFirstByOrderByIdDesc();
        this.idGenerator = new ShortIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Type type) {
        TypeMongoEntity typeMongoEntity = TypeOutBoundMapper.toTypeJpaEntity(type);
        typeMongoRepository.save(typeMongoEntity);
        typeInMemoryRepository.add(type.getId(), type);
    }

    @Override
    public short generateId() {
        return idGenerator.generate();
    }

    @Override
    public Type read(short id) {
        return typeInMemoryRepository.get(id).orElseThrow(() -> new EntityNotFoundException("type id " + id + " not found"));
    }

    @Override
    public Page<Type> searchByNameContained(String name, Pageable pageable) {
        return typeMongoRepository.findByNameContaining(name, pageable).map(TypeOutBoundMapper::toType);
    }

    @Override
    public void update(Type type) {
        TypeMongoEntity typeMongoEntity = TypeOutBoundMapper.toTypeJpaEntity(type);
        typeMongoRepository.save(typeMongoEntity);
        typeInMemoryRepository.add(type.getId(), type);
    }

    @Override
    public void delete(short id) {
        typeMongoRepository.deleteById(id);
        typeInMemoryRepository.remove(id);
    }
}
