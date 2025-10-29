package com.kdedevelop.mediani.infrastructure.adapter.out.generator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShortIdGenerator {
    public ShortIdGenerator(short lastId) {
        this.lastId = lastId;
        this.lock = new ReentrantLock();
    }

    private short lastId;
    private final Lock lock;

    public short generate() {
        lock.lock();
        try {
            if (lastId == Short.MAX_VALUE) throw new IllegalStateException("ShortIdGenerator cannot generate more than " + Short.MAX_VALUE);
            return ++ lastId;
        } finally {
            lock.unlock();
        }
    }
}
