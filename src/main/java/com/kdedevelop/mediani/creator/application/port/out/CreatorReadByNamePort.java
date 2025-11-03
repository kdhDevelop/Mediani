package com.kdedevelop.mediani.creator.application.port.out;

import com.kdedevelop.mediani.creator.domain.Creator;

import java.util.Optional;

public interface CreatorReadByNamePort {
    Optional<Creator> readByName(String name);
}
