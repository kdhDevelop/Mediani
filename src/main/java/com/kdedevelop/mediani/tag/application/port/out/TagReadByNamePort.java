package com.kdedevelop.mediani.tag.application.port.out;

import com.kdedevelop.mediani.tag.domain.Tag;

import java.util.Optional;

public interface TagReadByNamePort {
    Optional<Tag> readByName(String name);
}
