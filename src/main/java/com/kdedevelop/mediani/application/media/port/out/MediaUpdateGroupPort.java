package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Group;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateGroupPort {
    void addGroup(Media media, Group group);
    void deleteGroup(Media media, Group group);
}
