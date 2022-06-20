package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.cache.MyCache;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {

    @Bean
    public SimpleCacheManager simpleCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        Set<Cache> caches = new HashSet<>();
        caches.add(new MyCache());
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }
}
