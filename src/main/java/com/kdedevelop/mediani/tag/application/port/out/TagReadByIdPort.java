package com.kdedevelop.mediani.tag.application.port.out;

import com.kdedevelop.mediani.tag.domain.Tag;

import java.util.Optional;

public interface TagReadByIdPort {
    Optional<Tag> read(long id);
}
