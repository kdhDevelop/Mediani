package com.kdedevelop.mediani.series.adapter.out.mapper;

import com.kdedevelop.mediani.series.adapter.out.mongo.SeriesMongoEntity;
import com.kdedevelop.mediani.series.domain.Series;

public class SeriesOutBoundMapper {
    public static Series toSeries(SeriesMongoEntity seriesMongoEntity) {
        return new Series(seriesMongoEntity.getId(), seriesMongoEntity.getName());
    }

    public static SeriesMongoEntity toSeriesMongoEntity(Series series) {
        return new SeriesMongoEntity(series.getId(), series.getName());
    }
}
