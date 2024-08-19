package com.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache); // Output: {1=One, 2=Two, 3=Three}

        cache.get(1); // Move key 1 to the end
        cache.put(4, "Four"); // Remove the least recently used entry (key 2)

        System.out.println(cache); // Output: {3=Three, 1=One, 4=Four}
    }
}
