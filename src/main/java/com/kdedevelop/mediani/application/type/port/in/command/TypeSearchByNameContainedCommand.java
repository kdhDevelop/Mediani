package com.kdedevelop.mediani.application.type.port.in.command;

import org.springframework.data.domain.Pageable;

public record TypeSearchByNameContainedCommand(String name, Pageable pageable) {
}
