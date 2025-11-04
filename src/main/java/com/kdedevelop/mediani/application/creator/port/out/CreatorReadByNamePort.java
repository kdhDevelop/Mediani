package com.kdedevelop.mediani.application.creator.port.out;

import com.kdedevelop.mediani.domain.Creator;

import java.util.Optional;

public interface CreatorReadByNamePort {
    Optional<Creator> readByName(String name);
}
