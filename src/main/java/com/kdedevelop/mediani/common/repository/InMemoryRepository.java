package com.kdedevelop.mediani.common.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<K, V> {
    public InMemoryRepository() {
        this.map = new HashMap<>();
    }

    private final Map<K, V> map;

    public void add(K key, V value) {
        map.put(key, value);
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(map.get(key));
    }

    public void remove(K key) {
        map.remove(key);
    }
}
