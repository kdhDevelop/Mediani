package com.kdedevelop.mediani.application.series.port.in.usecase;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesReadCommand;
import com.kdedevelop.mediani.domain.Series;

public interface SeriesReadUseCase {
    Series read(SeriesReadCommand command);
}
