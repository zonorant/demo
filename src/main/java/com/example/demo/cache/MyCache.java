package com.example.demo.cache;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;

public class MyCache implements Cache {

    private String name = "default";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object o) {
        if (!(o instanceof BasicCacheKey)) {
            throw new RuntimeException("is not legal param");
        }


        return null;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object o, Object o1) {
        System.out.println("aaa");
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object o) {
        System.out.println("bbb");
    }

    @Override
    public void clear() {
        System.out.println("ccc");
    }
}
