package com.kdedevelop.mediani.adapter.out.series.mapper;

import com.kdedevelop.mediani.adapter.out.series.mybatis.SeriesMyBatisEntity;
import com.kdedevelop.mediani.domain.Series;

public class SeriesOutBoundMapper {
    public static Series toSeries(SeriesMyBatisEntity seriesMyBatisEntity) {
        return new Series(seriesMyBatisEntity.getId(), seriesMyBatisEntity.getName());
    }

    public static SeriesMyBatisEntity toSeriesMyBatisEntity(Series series) {
        return new SeriesMyBatisEntity(series.getId(), series.getName());
    }
}
