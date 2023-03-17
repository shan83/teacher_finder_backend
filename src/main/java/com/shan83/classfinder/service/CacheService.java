package com.shan83.classfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames().stream()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    public void evictSelectedCache(String name) {
        cacheManager.getCacheNames().stream()
                .forEach(cacheName -> {
                    if (name.equals(cacheName)) {
                        cacheManager.getCache(cacheName).clear();
                    }
                });
    }

//	@Scheduled(cron = "@weekly")
//	public void evictAllcachesAtIntervals() {
//	    evictAllCaches();
//	}
}
