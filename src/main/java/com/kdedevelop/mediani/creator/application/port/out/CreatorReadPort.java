package com.kdedevelop.mediani.creator.application.port.out;

import com.kdedevelop.mediani.creator.domain.Creator;

public interface CreatorReadPort {
    Creator read(long id);
}
