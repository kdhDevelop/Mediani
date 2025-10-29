package com.kdedevelop.mediani.group.application.port.out;

import com.kdedevelop.mediani.group.domain.Group;

public interface GroupReadPort {
    Group read(long id);
}
