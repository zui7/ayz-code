package org.example.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUByLHM extends LinkedHashMap<Integer, Integer> {
    private final int maxCapacity;

    public LRUByLHM(int capacity) {
        super(capacity, 0.75f, true);
        maxCapacity = capacity;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > maxCapacity;
    }

    public static void main(String[] args) {
        LRUByLHM cache = new LRUByLHM(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);      //123

        cache.put(1, 0);      //231
        cache.put(4, 4);      //2314
        cache.put(5, 1);      //3145
        cache.keySet().forEach(System.out::print);
        System.out.println();
        cache.get(1);         //3451
        cache.get(3);         //4513

        cache.keySet().forEach(System.out::print);
        System.out.println();
    }

}
