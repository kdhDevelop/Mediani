package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Creator;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateCreatorPort {
    void addCreator(Media media, Creator creator);
    void deleteCreator(Media media, Creator creator);
}
