package com.kdedevelop.mediani.media.application.port.out;

import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.media.domain.Media;

public interface MediaUpdateCharacterPort {
    void addCharacter(Media media, Character character);
    void deleteCharacter(Media media, Character character);
}
