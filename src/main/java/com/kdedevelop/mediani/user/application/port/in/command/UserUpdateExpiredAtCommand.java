package com.kdedevelop.mediani.user.application.port.in.command;

import java.time.LocalDateTime;

public record UserUpdateExpiredAtCommand(int id, LocalDateTime expiredAt) {
}
