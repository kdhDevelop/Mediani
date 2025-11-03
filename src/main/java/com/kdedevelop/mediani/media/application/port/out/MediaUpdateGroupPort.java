package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.group.domain.Group;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateGroupPort {
    void addGroup(Media media, Group group);
    void deleteGroup(Media media, Group group);
}
