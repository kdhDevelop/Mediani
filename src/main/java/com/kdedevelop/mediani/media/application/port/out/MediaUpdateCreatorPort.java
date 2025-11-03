package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.creator.domain.Creator;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateCreatorPort {
    void addCreator(Media media, Creator creator);
    void deleteCreator(Media media, Creator creator);
}
