package com.kdedevelop.mediani.media.application.port.in.usecase;

import com.kdedevelop.mediani.media.application.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaReadByIdUseCase {
    Media readById(MediaReadByIdCommand command);
}
