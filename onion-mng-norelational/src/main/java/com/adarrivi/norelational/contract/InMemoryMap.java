package com.adarrivi.norelational.contract;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryMap {

    private ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public ConcurrentMap<String, String> getMap() {
        return map;
    }

}
