package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Series;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateSeriesPort {
    void addSeries(Media media, Series series);
    void deleteSeries(Media media, Series series);
}
