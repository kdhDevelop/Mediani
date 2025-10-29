package com.kdedevelop.mediani.character.application.port.in.usecase;

import com.kdedevelop.mediani.character.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterSearchByNameContainedUseCase {
    Page<Character> searchByNameContained(String name, Pageable pageable);
}
