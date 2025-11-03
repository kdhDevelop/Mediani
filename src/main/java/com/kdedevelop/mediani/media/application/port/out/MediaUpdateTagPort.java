package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateTagPort {
    void addTag(Media media, Tag tag);
    void deleteTag(Media media, Tag tag);
}
