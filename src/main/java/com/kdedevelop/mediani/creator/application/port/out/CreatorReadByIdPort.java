package com.kdedevelop.mediani.creator.application.port.out;

import com.kdedevelop.mediani.creator.domain.Creator;

import java.util.Optional;

public interface CreatorReadByIdPort {
    Optional<Creator> readById(long id);
}
