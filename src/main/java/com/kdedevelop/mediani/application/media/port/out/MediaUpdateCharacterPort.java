package com.kdedevelop.mediani.application.media.port.out;

import com.kdedevelop.mediani.domain.Character;
import com.kdedevelop.mediani.domain.Media;

public interface MediaUpdateCharacterPort {
    void addCharacter(Media media, Character character);
    void deleteCharacter(Media media, Character character);
}
