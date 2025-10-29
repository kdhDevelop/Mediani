package com.kdedevelop.mediani.user.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.user.adapter.out.jpa.UserMongoEntity;
import com.kdedevelop.mediani.user.adapter.out.jpa.UserMongoRepository;
import com.kdedevelop.mediani.user.adapter.out.mapper.UserOutBoundMapper;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRegisterPort, UserLoginIdDuplicateCheckPort, UserFindByLoginIdPort, UserFindByIdPort, UserUpdatePort, UserUpdatePasswordPort, UserDeletePort, UserFindLatestIdPort, UserUpdateLockStatePort, UserUpdateRolePort, UserUpdateExpiredAtPort {
    private final UserMongoRepository userRepository;

    @Override
    public void register(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public boolean isDuplicate(String loginId) {
        return !userRepository.existsByLoginId(loginId);
    }

    @Override
    public User findByLoginId(String loginId) {
        return UserOutBoundMapper.toUser(userRepository.findByLoginId(loginId).orElseThrow(() -> new EntityNotFoundException("user login id " + loginId + " is not found.")));
    }

    @Override
    public void update(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public User findById(int id) {
        return UserOutBoundMapper.toUser(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user id " + id + " is not found.")));
    }

    @Override
    public void updatePassword(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public void delete(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public int getLastUserId() {
        Optional<UserMongoEntity> user = userRepository.findTopByOrderByIdDesc();
        return user.map(UserMongoEntity::getId).orElse(0);
    }

    @Override
    public void updateExpiredAt(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public void updateLockState(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }

    @Override
    public void updateRole(User user) {
        UserMongoEntity userMongoEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userMongoEntity);
    }
}
