package com.kdedevelop.mediani.adapter.in.type.mapper;

import com.kdedevelop.mediani.adapter.in.type.dto.TypeCreateRequest;
import com.kdedevelop.mediani.adapter.in.type.dto.TypeUpdateRequest;
import com.kdedevelop.mediani.application.type.port.in.command.*;
import org.springframework.data.domain.Pageable;

public class TypeInBoundMapper {
    public static TypeCreateCommand toCreateCommand(TypeCreateRequest request) {
        return new TypeCreateCommand(request.name());
    }

    public static TypeReadCommand toReadCommand(short id) {
        return new TypeReadCommand(id);
    }

    public static TypeSearchByNameContainedCommand toSearchByNameContainedCommand(String name, Pageable pageable) {
        return new TypeSearchByNameContainedCommand(name, pageable);
    }

    public static TypeUpdateCommand toUpdateCommand(short id, TypeUpdateRequest request) {
        return new TypeUpdateCommand(id, request.name());
    }

    public static TypeDeleteCommand toDeleteCommand(short id) {
        return new TypeDeleteCommand(id);
    }
}
