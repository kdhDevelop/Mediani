package com.kdedevelop.mediani.application.tag.port.out;

import com.kdedevelop.mediani.domain.Tag;

import java.util.Optional;

public interface TagReadByIdPort {
    Optional<Tag> read(long id);
}
