package com.kdedevelop.mediani.application.tag.port.out;

import com.kdedevelop.mediani.domain.Tag;

import java.util.Optional;

public interface TagReadByNamePort {
    Optional<Tag> readByName(String name);
}
