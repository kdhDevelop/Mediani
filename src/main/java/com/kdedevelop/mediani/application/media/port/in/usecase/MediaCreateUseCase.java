package com.kdedevelop.mediani.application.media.port.in.usecase;

import com.kdedevelop.mediani.application.media.port.in.command.MediaCreateCommand;

public interface MediaCreateUseCase {
    void create(MediaCreateCommand command);
}
