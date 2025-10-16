package com.kdedevelop.mediani.infrastructure.adapter.in.web.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int code, String error, String message, LocalDateTime timestamp) {
}
