package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Media;

import java.util.Optional;

public interface MediaReadByIdPort {
    Optional<Media> readById(short typeId, long mediaId);
}
