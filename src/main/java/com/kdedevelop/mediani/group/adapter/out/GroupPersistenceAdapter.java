package com.kdedevelop.mediani.group.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.group.adapter.out.mapper.GroupOutBoundMapper;
import com.kdedevelop.mediani.group.adapter.out.mongo.GroupMongoEntity;
import com.kdedevelop.mediani.group.adapter.out.mongo.GroupMongoRepository;
import com.kdedevelop.mediani.group.application.port.out.*;
import com.kdedevelop.mediani.group.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GroupPersistenceAdapter implements GroupCreatePort, GroupGenerateIdPort, GroupReadPort, GroupSearchByNameContainedPort, GroupUpdatePort {
    private final GroupMongoRepository groupMongoRepository;
    private final LongIdGenerator idGenerator;

    public GroupPersistenceAdapter(@Autowired GroupMongoRepository groupMongoRepository) {
        this.groupMongoRepository = groupMongoRepository;

        Optional<GroupMongoEntity> entity = groupMongoRepository.findFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Group group) {
        GroupMongoEntity entity = GroupOutBoundMapper.toGroupMongoEntity(group);
        groupMongoRepository.save(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Group read(long id) {
        return GroupOutBoundMapper.toGroup(groupMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("group id : " + id + " not found")));
    }

    @Override
    public Page<Group> searchGroupByNameContained(String name, Pageable pageable) {
        return groupMongoRepository.findByNameContaining(name, pageable).map(GroupOutBoundMapper::toGroup);
    }

    @Override
    public void update(Group group) {
        GroupMongoEntity entity = GroupOutBoundMapper.toGroupMongoEntity(group);
        groupMongoRepository.save(entity);
    }
}
