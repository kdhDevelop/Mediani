package com.kdedevelop.mediani.application.character.port.in.usecase;

import com.kdedevelop.mediani.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterSearchByNameContainedUseCase {
    Page<Character> searchByNameContained(String name, Pageable pageable);
}
