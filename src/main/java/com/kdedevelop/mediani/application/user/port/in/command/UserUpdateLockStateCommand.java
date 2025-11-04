package com.kdedevelop.mediani.application.user.port.in.command;

public record UserUpdateLockStateCommand(int id, boolean lock) {
}
