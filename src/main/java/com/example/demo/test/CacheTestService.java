package com.example.demo.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTestService {

    @Cacheable(key = "#aaa", cacheNames = "default")
    public List<String> getData(String aaa) {
        List<String> data = Arrays.asList("aaa", "bbb", "ccc");
        return data;
    }
}
