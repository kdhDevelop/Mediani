package com.kdedevelop.mediani.series.adapter.out.mapper;

import com.kdedevelop.mediani.series.adapter.out.mybatis.SeriesMyBatisEntity;
import com.kdedevelop.mediani.series.domain.Series;

public class SeriesOutBoundMapper {
    public static Series toSeries(SeriesMyBatisEntity seriesMyBatisEntity) {
        return new Series(seriesMyBatisEntity.getId(), seriesMyBatisEntity.getName());
    }

    public static SeriesMyBatisEntity toSeriesMyBatisEntity(Series series) {
        return new SeriesMyBatisEntity(series.getId(), series.getName());
    }
}
