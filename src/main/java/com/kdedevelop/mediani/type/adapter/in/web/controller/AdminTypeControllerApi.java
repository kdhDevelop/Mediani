package com.kdedevelop.mediani.type.adapter.in.web.controller;

import com.kdedevelop.mediani.type.adapter.in.dto.TypeCreateRequest;
import com.kdedevelop.mediani.type.adapter.in.dto.TypeUpdateRequest;
import com.kdedevelop.mediani.type.adapter.in.mapper.TypeInBoundMapper;
import com.kdedevelop.mediani.type.application.port.in.usecase.TypeCreateUseCase;
import com.kdedevelop.mediani.type.application.port.in.usecase.TypeDeleteUseCase;
import com.kdedevelop.mediani.type.application.port.in.usecase.TypeUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class AdminTypeControllerApi {
    private final TypeCreateUseCase typeCreateUseCase;
    private final TypeUpdateUseCase typeUpdateUseCase;
    private final TypeDeleteUseCase typeDeleteUseCase;

    @PostMapping(value = "/")
    public void create(TypeCreateRequest typeCreateRequest) {
        typeCreateUseCase.create(TypeInBoundMapper.toCreateCommand(typeCreateRequest));
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable short id, @RequestBody TypeUpdateRequest typeUpdateRequest) {
        typeUpdateUseCase.update(TypeInBoundMapper.toUpdateCommand(id, typeUpdateRequest));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable short id) {
        typeDeleteUseCase.delete(TypeInBoundMapper.toDeleteCommand(id));
    }
}
