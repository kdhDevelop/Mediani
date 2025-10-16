package com.kdedevelop.mediani.user.application.port.in.command;

public record UserUpdateLockStateCommand(int id, boolean lock) {
}
