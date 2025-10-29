package com.kdedevelop.mediani.type.application.port.out;

import com.kdedevelop.mediani.type.domain.Type;

public interface TypeReadPort {
    Type read(short id);
}
