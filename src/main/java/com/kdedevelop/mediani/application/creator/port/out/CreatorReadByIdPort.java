package com.kdedevelop.mediani.application.creator.port.out;

import com.kdedevelop.mediani.domain.Creator;

import java.util.Optional;

public interface CreatorReadByIdPort {
    Optional<Creator> readById(long id);
}
