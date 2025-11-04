package com.kdedevelop.mediani.application.media.port.in.usecase;

import com.kdedevelop.mediani.application.media.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.domain.Media;

public interface MediaReadByIdUseCase {
    Media readById(MediaReadByIdCommand command);
}
