package com.kdedevelop.mediani.media.application.port.in.usecase;

import com.kdedevelop.mediani.media.application.port.in.command.MediaCreateCommand;

public interface MediaCreateUseCase {
    void create(MediaCreateCommand command);
}
