package com.kdedevelop.mediani.application.type.port.out;

import com.kdedevelop.mediani.domain.Type;

import java.util.Optional;

public interface TypeReadByIdPort {
    Optional<Type> readById(short id);
}
