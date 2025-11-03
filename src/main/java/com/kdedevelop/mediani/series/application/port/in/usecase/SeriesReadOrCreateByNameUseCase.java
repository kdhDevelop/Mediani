package com.kdedevelop.mediani.series.application.port.in.usecase;

import com.kdedevelop.mediani.series.application.port.in.command.SeriesReadOrCreateByNameCommand;
import com.kdedevelop.mediani.series.domain.Series;

public interface SeriesReadOrCreateByNameUseCase {
    Series readOrCreateByName(SeriesReadOrCreateByNameCommand command);
}
