package com.kdedevelop.mediani.tag.application.port.out;

import com.kdedevelop.mediani.tag.domain.Tag;

public interface TagReadPort {
    Tag read(long id);
}
