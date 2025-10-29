package com.kdedevelop.mediani.type.application.port.in.command;

import org.springframework.data.domain.Pageable;

public record TypeSearchByNameContainedCommand(String name, Pageable pageable) {
}
