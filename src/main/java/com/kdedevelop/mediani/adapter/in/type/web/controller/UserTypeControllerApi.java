package com.kdedevelop.mediani.adapter.in.type.web.controller;

import com.kdedevelop.mediani.adapter.in.type.mapper.TypeInBoundMapper;
import com.kdedevelop.mediani.application.type.port.in.usecase.TypeReadUseCase;
import com.kdedevelop.mediani.application.type.port.in.usecase.TypeSearchByNameContainedUseCase;
import com.kdedevelop.mediani.domain.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class UserTypeControllerApi {
    private final TypeReadUseCase typeReadUseCase;
    private final TypeSearchByNameContainedUseCase typeSearchByNameContainedUseCase;

    @GetMapping(value = "/{id}")
    public Type read(@PathVariable short id) {
        return typeReadUseCase.read(TypeInBoundMapper.toReadCommand(id));
    }

    @GetMapping(value = "/")
    public Page<Type> searchByNameContained(@RequestParam(value = "name") String name, Pageable pageable) {
        return typeSearchByNameContainedUseCase.searchByNameContained(TypeInBoundMapper.toSearchByNameContainedCommand(name, pageable));
    }
}
