package com.kdedevelop.mediani.application.character.port.out;

import com.kdedevelop.mediani.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CharacterSearchByNameContainedPort {
    Page<Character> searchByNameContained(String name, Pageable pageable);
}
