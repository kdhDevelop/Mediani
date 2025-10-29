package com.kdedevelop.mediani.series.application.port.in.usecase;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesCreateCommand;

public interface SeriesCreateUseCase {
    void create(SeriesCreateCommand command);
}
