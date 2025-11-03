package com.kdedevelop.mediani.type.application.port.out;

import com.kdedevelop.mediani.type.domain.Type;

import java.util.Optional;

public interface TypeReadByNamePort {
    Optional<Type> readByName(String name);
}
