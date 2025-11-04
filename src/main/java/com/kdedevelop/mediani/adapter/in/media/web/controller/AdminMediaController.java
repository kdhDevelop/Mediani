package com.kdedevelop.mediani.adapter.in.media.web.controller;

import com.kdedevelop.mediani.adapter.in.media.dto.MediaCreateRequest;
import com.kdedevelop.mediani.adapter.in.media.dto.MediaReadResponse;
import com.kdedevelop.mediani.adapter.in.media.mapper.MediaInBoundMapper;
import com.kdedevelop.mediani.application.media.port.in.usecase.MediaCreateUseCase;
import com.kdedevelop.mediani.application.media.port.in.usecase.MediaReadByIdUseCase;
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
