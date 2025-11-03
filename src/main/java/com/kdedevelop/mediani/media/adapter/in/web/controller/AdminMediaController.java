package com.kdedevelop.mediani.media.adapter.in.web.controller;

import com.kdedevelop.mediani.media.adapter.in.dto.MediaCreateRequest;
import com.kdedevelop.mediani.media.adapter.in.dto.MediaReadResponse;
import com.kdedevelop.mediani.media.adapter.in.mapper.MediaInBoundMapper;
import com.kdedevelop.mediani.media.application.port.in.usecase.MediaCreateUseCase;
import com.kdedevelop.mediani.media.application.port.in.usecase.MediaReadByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/admin/v0/media")
public class AdminMediaController {
    private final MediaCreateUseCase mediaCreateUseCase;
    private final MediaReadByIdUseCase mediaReadByIdUseCase;

    @PostMapping(value = "")
    public void create(@RequestBody MediaCreateRequest mediaCreateRequest) {
        mediaCreateUseCase.create(MediaInBoundMapper.toCreateCommand(mediaCreateRequest));
    }

    @GetMapping(value = "/{typeId}/{mediaId}")
    public MediaReadResponse read(@PathVariable short typeId, @PathVariable long mediaId) {
        return MediaInBoundMapper.toMediaReadResponse(mediaReadByIdUseCase.readById(MediaInBoundMapper.toReadByIdCommand(typeId, mediaId)));
    }
}
