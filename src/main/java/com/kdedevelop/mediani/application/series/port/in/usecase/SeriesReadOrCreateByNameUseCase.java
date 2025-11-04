package com.kdedevelop.mediani.application.series.port.in.usecase;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesReadOrCreateByNameCommand;
import com.kdedevelop.mediani.domain.Series;

public interface SeriesReadOrCreateByNameUseCase {
    Series readOrCreateByName(SeriesReadOrCreateByNameCommand command);
}
