package com.kdedevelop.mediani.group.adapter.out;

import com.kdedevelop.mediani.group.adapter.out.mapper.GroupOutBoundMapper;
import com.kdedevelop.mediani.group.adapter.out.mybatis.GroupMyBatisEntity;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.group.adapter.out.mybatis.GroupMyBatisRepository;
import com.kdedevelop.mediani.group.application.port.out.*;
import com.kdedevelop.mediani.group.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupPersistenceAdapterById implements GroupCreatePort, GroupGenerateIdPort, GroupReadByIdPort, GroupReadByNamePort, GroupSearchByNameContainedPort, GroupUpdatePort {
    private final GroupMyBatisRepository groupMyBatisRepository;
    private final LongIdGenerator idGenerator;

    public GroupPersistenceAdapterById(@Autowired GroupMyBatisRepository groupMyBatisRepository) {
        this.groupMyBatisRepository = groupMyBatisRepository;

        Optional<GroupMyBatisEntity> entity = groupMyBatisRepository.readFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Group group) {
        GroupMyBatisEntity entity = GroupOutBoundMapper.toGroupMyBatisEntity(group);
        groupMyBatisRepository.create(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Group> readById(long id) {
        return groupMyBatisRepository.readById(id).map(GroupOutBoundMapper::toGroup);
    }

    @Override
    public Optional<Group> readByName(String name) {
        return groupMyBatisRepository.readByName(name).map(GroupOutBoundMapper::toGroup);
    }

    @Override
    public Page<Group> searchGroupByNameContained(String name, Pageable pageable) {
        long totalElementCount = groupMyBatisRepository.countAll();
        List<GroupMyBatisEntity> result = groupMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(GroupOutBoundMapper::toGroup).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Group group) {
        GroupMyBatisEntity entity = GroupOutBoundMapper.toGroupMyBatisEntity(group);
        groupMyBatisRepository.update(entity);
    }
}
