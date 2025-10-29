package com.kdedevelop.mediani.infrastructure.adapter.in.web.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
