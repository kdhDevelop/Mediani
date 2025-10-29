package com.kdedevelop.mediani.series.application.port.in.usecase;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesUpdateCommand;

public interface SeriesUpdateUseCase {
    void update(SeriesUpdateCommand command);
}
