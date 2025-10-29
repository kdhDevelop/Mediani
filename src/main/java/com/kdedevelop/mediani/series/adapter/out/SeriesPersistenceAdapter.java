package com.kdedevelop.mediani.series.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import com.kdedevelop.mediani.series.adapter.out.mapper.SeriesOutBoundMapper;
import com.kdedevelop.mediani.series.adapter.out.mongo.SeriesMongoEntity;
import com.kdedevelop.mediani.series.adapter.out.mongo.SeriesMongoRepository;
import com.kdedevelop.mediani.series.application.port.out.*;
import com.kdedevelop.mediani.series.domain.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SeriesPersistenceAdapter implements SeriesCreatePort, SeriesGenerateIdPort, SeriesReadPort, SeriesSearchByNameContainedPort, SeriesUpdatePort {
    private final SeriesMongoRepository seriesMongoRepository;
    private final LongIdGenerator idGenerator;

    public SeriesPersistenceAdapter(@Autowired SeriesMongoRepository seriesMongoRepository) {
        this.seriesMongoRepository = seriesMongoRepository;

        Optional<SeriesMongoEntity> entity = seriesMongoRepository.findFirstByOrderByIdDesc();
        idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Series series) {
        SeriesMongoEntity entity = SeriesOutBoundMapper.toSeriesMongoEntity(series);
        seriesMongoRepository.save(entity);
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Series read(long id) {
        return SeriesOutBoundMapper.toSeries(seriesMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("series id : " + id + " not found")));
    }

    @Override
    public Page<Series> searchSeriesByNameContained(String name, Pageable pageable) {
        return seriesMongoRepository.findByNameContaining(name, pageable).map(SeriesOutBoundMapper::toSeries);
    }

    @Override
    public void update(Series series) {
        SeriesMongoEntity entity = SeriesOutBoundMapper.toSeriesMongoEntity(series);
        seriesMongoRepository.save(entity);
    }
}
