package com.kdedevelop.mediani.application.type.port.out;

import com.kdedevelop.mediani.domain.Type;

import java.util.Optional;

public interface TypeReadByNamePort {
    Optional<Type> readByName(String name);
}
