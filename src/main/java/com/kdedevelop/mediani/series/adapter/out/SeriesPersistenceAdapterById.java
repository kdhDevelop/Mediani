package com.kdedevelop.mediani.series.adapter.out;

import com.kdedevelop.mediani.series.adapter.out.mapper.SeriesOutBoundMapper;
import com.kdedevelop.mediani.series.adapter.out.mybatis.SeriesMyBatisEntity;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.series.adapter.out.mybatis.SeriesMyBatisRepository;
import com.kdedevelop.mediani.series.application.port.out.*;
import com.kdedevelop.mediani.series.domain.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SeriesPersistenceAdapterById implements SeriesCreatePort, SeriesGenerateIdPort, SeriesReadByIdPort, SeriesReadByNamePort, SeriesSearchByNameContainedPort, SeriesUpdatePort {
    private final SeriesMyBatisRepository seriesMyBatisRepository;
    private final LongIdGenerator idGenerator;

    public SeriesPersistenceAdapterById(@Autowired SeriesMyBatisRepository seriesMyBatisRepository) {
        this.seriesMyBatisRepository = seriesMyBatisRepository;

        Optional<SeriesMyBatisEntity> entity = seriesMyBatisRepository.readFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Series series) {
        SeriesMyBatisEntity entity = SeriesOutBoundMapper.toSeriesMyBatisEntity(series);
        seriesMyBatisRepository.create(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Series> readById(long id) {
        return seriesMyBatisRepository.readById(id).map(SeriesOutBoundMapper::toSeries);
    }

    @Override
    public Optional<Series> readByName(String name) {
        return seriesMyBatisRepository.readByName(name).map(SeriesOutBoundMapper::toSeries);
    }

    @Override
    public Page<Series> searchSeriesByNameContained(String name, Pageable pageable) {
        long totalElementCount = seriesMyBatisRepository.countAll();
        List<SeriesMyBatisEntity> result = seriesMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(SeriesOutBoundMapper::toSeries).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Series series) {
        SeriesMyBatisEntity entity = SeriesOutBoundMapper.toSeriesMyBatisEntity(series);
        seriesMyBatisRepository.update(entity);
    }
}
