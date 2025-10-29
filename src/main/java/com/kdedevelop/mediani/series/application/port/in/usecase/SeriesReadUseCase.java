package com.kdedevelop.mediani.series.application.port.in.usecase;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesReadCommand;
import com.kdedevelop.mediani.series.domain.Series;

public interface SeriesReadUseCase {
    Series read(SeriesReadCommand command);
}
