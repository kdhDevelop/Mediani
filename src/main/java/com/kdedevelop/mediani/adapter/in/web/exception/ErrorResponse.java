package com.kdedevelop.mediani.adapter.in.web.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int code, String error, String message, LocalDateTime timestamp) {
}
