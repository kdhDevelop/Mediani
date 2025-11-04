package com.kdedevelop.mediani.application.series.port.in.usecase;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesCreateCommand;

public interface SeriesCreateUseCase {
    void create(SeriesCreateCommand command);
}
