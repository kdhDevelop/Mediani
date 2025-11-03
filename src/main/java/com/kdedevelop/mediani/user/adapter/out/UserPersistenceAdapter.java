package com.kdedevelop.mediani.user.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.IntegerIdGenerator;
import com.kdedevelop.mediani.user.adapter.out.mybatis.UserMyBatisEntity;
import com.kdedevelop.mediani.user.adapter.out.mybatis.UserMyBatisRepository;
import com.kdedevelop.mediani.user.adapter.out.mapper.UserOutBoundMapper;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPersistenceAdapter implements UserCreatePort, UserLoginIdDuplicateCheckPort, UserReadByLoginIdPort, UserReadByIdPort, UserUpdatePort, UserUpdatePasswordPort, UserDeletePort, UserGenerateIdPort, UserUpdateLockStatePort, UserUpdateRolePort, UserUpdateExpiredAtPort {
    private final UserMyBatisRepository userRepository;
    private final IntegerIdGenerator idGenerator;

    public UserPersistenceAdapter(@Autowired UserMyBatisRepository userRepository) {
        this.userRepository = userRepository;

        Optional<UserMyBatisEntity> entity = userRepository.readFirstByOrderByIdDesc();
        this.idGenerator = new IntegerIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.create(userMyBatisEntity);
    }

    @Override
    public boolean isDuplicate(String loginId) {
        return !userRepository.existsByLoginId(loginId);
    }

    @Override
    public User readByLoginId(String loginId) {
        return UserOutBoundMapper.toUser(userRepository.readByLoginId(loginId).orElseThrow(() -> new EntityNotFoundException("user login id " + loginId + " is not found.")));
    }

    @Override
    public void update(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }

    @Override
    public User readById(int id) {
        return UserOutBoundMapper.toUser(userRepository.readById(id).orElseThrow(() -> new EntityNotFoundException("user id " + id + " is not found.")));
    }

    @Override
    public void updatePassword(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }

    @Override
    public void delete(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }

    @Override
    public int generateId() {
        return idGenerator.generate();
    }

    @Override
    public void updateExpiredAt(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }

    @Override
    public void updateLockState(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }

    @Override
    public void updateRole(User user) {
        UserMyBatisEntity userMyBatisEntity = UserOutBoundMapper.toUserMyBatisEntity(user);
        userRepository.update(userMyBatisEntity);
    }
}
