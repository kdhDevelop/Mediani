package com.kdedevelop.mediani.character.application.port.out;

import com.kdedevelop.mediani.character.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CharacterSearchByNameContainedPort {
    Page<Character> searchByNameContained(String name, Pageable pageable);
}
