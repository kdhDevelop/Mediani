package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.media.domain.Media;

import java.util.Optional;

public interface MediaReadByIdPort {
    Optional<Media> readById(short typeId, long mediaId);
}
