package com.kdedevelop.mediani.application.series.port.in.usecase;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesUpdateCommand;

public interface SeriesUpdateUseCase {
    void update(SeriesUpdateCommand command);
}
