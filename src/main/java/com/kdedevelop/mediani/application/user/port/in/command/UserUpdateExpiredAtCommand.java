package com.kdedevelop.mediani.application.user.port.in.command;

import java.time.LocalDateTime;

public record UserUpdateExpiredAtCommand(int id, LocalDateTime expiredAt) {
}
