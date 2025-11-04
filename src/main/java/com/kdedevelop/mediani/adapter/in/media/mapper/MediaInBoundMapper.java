package com.kdedevelop.mediani.adapter.in.media.mapper;

import com.kdedevelop.mediani.adapter.in.media.dto.MediaCreateRequest;
import com.kdedevelop.mediani.adapter.in.media.dto.MediaReadResponse;
import com.kdedevelop.mediani.application.media.port.in.command.MediaCreateCommand;
import com.kdedevelop.mediani.application.media.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.domain.Media;

public class MediaInBoundMapper {
    public static MediaCreateCommand toCreateCommand(MediaCreateRequest request) {
        return new MediaCreateCommand(request.id(), request.type(), request.cover(), request.title(), request.description(), request.language(), request.character(), request.creator(), request.group(), request.producer(), request.series(), request.tag());
    }

    public static MediaReadByIdCommand toReadByIdCommand(short typeId, long mediaId) {
        return new MediaReadByIdCommand(typeId, mediaId);
    }

    public static MediaReadResponse toMediaReadResponse(Media media) {
        return new MediaReadResponse(media.getId(), media.getType(), media.getCover(), media.getTitle(), media.getDescription(), media.getLanguage(), media.getCreatedAt(), media.getUpdatedAt(), media.getCharacter(), media.getCreator(), media.getGroup(), media.getProducer(), media.getSeries(), media.getTag());
    }
}
