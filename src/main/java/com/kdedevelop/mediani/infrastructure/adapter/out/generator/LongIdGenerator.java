package com.kdedevelop.mediani.infrastructure.adapter.out.generator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LongIdGenerator {
    public LongIdGenerator(long lastId) {
        this.lastId = lastId;
        this.lock = new ReentrantLock();
    }

    private long lastId;
    private final Lock lock;

    public long generate() {
        lock.lock();
        try {
            if (lastId == Long.MAX_VALUE) throw new IllegalStateException("LongIdGenerator cannot generate more than " + Long.MAX_VALUE);
            return ++ lastId;
        } finally {
            lock.unlock();
        }
    }
}
