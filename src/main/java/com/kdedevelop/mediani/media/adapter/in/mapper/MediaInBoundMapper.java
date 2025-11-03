package com.kdedevelop.mediani.media.adapter.in.mapper;

import com.kdedevelop.mediani.media.adapter.in.dto.MediaCreateRequest;
import com.kdedevelop.mediani.media.adapter.in.dto.MediaReadResponse;
import com.kdedevelop.mediani.media.application.port.in.command.MediaCreateCommand;
import com.kdedevelop.mediani.media.application.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.media.domain.Media;

public class MediaInBoundMapper {
    public static MediaCreateCommand toCreateCommand(MediaCreateRequest request) {
        return new MediaCreateCommand(request.id(), request.type(), request.cover(), request.title(), request.language(), request.character(), request.creator(), request.group(), request.producer(), request.series(), request.tag());
    }

    public static MediaReadByIdCommand toReadByIdCommand(short typeId, long mediaId) {
        return new MediaReadByIdCommand(typeId, mediaId);
    }

    public static MediaReadResponse toMediaReadResponse(Media media) {
        return new MediaReadResponse(media.getId(), media.getType(), media.getCover(), media.getTitle(), media.getLanguage(), media.getCreatedAt(), media.getUpdatedAt(), media.getCharacter(), media.getCreator(), media.getGroup(), media.getProducer(), media.getSeries(), media.getTag());
    }
}
