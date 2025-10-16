package com.kdedevelop.mediani.user.adapter.out;

import com.kdedevelop.mediani.user.adapter.out.jpa.UserJpaEntity;
import com.kdedevelop.mediani.user.adapter.out.jpa.UserJpaRepository;
import com.kdedevelop.mediani.user.adapter.out.mapper.UserOutBoundMapper;
import com.kdedevelop.mediani.user.application.port.out.*;
import com.kdedevelop.mediani.user.domain.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginFindLatestPersistenceAdapter implements UserRegisterPort, UserLoginIdDuplicateCheckPort, UserFindByLoginIdPort, UserFindByIdPort, UserUpdatePort, UserUpdatePasswordPort, UserDeletePort, UserFindLatestIdPort {
    private final UserJpaRepository userRepository;

    @Override
    public void register(User user) {
        UserJpaEntity userJpaEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userJpaEntity);
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
        UserJpaEntity userJpaEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userJpaEntity);
    }

    @Override
    public User findById(int id) {
        return UserOutBoundMapper.toUser(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user id " + id + " is not found.")));
    }

    @Override
    public void updatePassword(User user) {
        UserJpaEntity userJpaEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userJpaEntity);
    }

    @Override
    public void delete(User user) {
        UserJpaEntity userJpaEntity = UserOutBoundMapper.toUserJpaEntity(user);
        userRepository.save(userJpaEntity);
    }

    @Override
    public int getLastUserId() {
        Optional<UserJpaEntity> user = userRepository.findTopByOrderByIdDesc();
        return user.map(UserJpaEntity::getId).orElse(0);
    }
}
