package com.kdedevelop.mediani.infrastructure.adapter.out.generator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerIdGenerator {
    public IntegerIdGenerator(int lastId) {
        this.lastId = lastId;
        this.lock = new ReentrantLock();
    }

    private int lastId;
    private final Lock lock;

    public int generate() {
        lock.lock();
        try {
            if (lastId == Integer.MAX_VALUE) throw new IllegalStateException("IntegerIdGenerator cannot generate more than " + Integer.MAX_VALUE);
            return ++ lastId;
        } finally {
            lock.unlock();
        }
    }
}
