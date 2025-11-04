package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Tag;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateTagPort {
    void addTag(Media media, Tag tag);
    void deleteTag(Media media, Tag tag);
}
