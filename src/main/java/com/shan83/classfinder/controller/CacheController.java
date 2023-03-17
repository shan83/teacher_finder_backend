package com.shan83.classfinder.controller;

import com.shan83.classfinder.dto.Message;
import com.shan83.classfinder.service.CacheService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cache")
@Slf4j
public class CacheController {

    private CacheService cacheService;

    @GetMapping
    @RequestMapping("/clear")
    public Message clearAllCaches(HttpServletRequest request,
                                  @RequestParam(name="cacheName", required = false) String cacheName) {
        if (cacheName != null && !cacheName.isEmpty()) {
            log.info("CLEAR CACHE OF : " + cacheName);
            cacheService.evictSelectedCache(cacheName);
        } else {
            log.info("CLEAR ALL CACHES");
            cacheService.evictAllCaches();
        }

        return new Message("Success");

    }
}
