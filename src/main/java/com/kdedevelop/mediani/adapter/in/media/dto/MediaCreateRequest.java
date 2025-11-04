package com.kdedevelop.mediani.adapter.in.media.dto;

import java.util.List;

public record MediaCreateRequest(
        long id,
        String type,
        String cover,
        String title,
        String description,
        String language,
        List<String> character,
        List<String> creator,
        List<String> group,
        List<String> producer,
        List<String> series,
        List<String> tag
) {
}
