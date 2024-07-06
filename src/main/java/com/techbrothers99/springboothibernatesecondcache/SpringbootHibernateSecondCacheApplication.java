package com.techbrothers99.springboothibernatesecondcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.CacheManager;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableCaching
public class SpringbootHibernateSecondCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateSecondCacheApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager() throws URISyntaxException {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager(getClass().getResource("/ehcache.xml").toURI(), getClass().getClassLoader());
        return new JCacheCacheManager(cacheManager);
    }
}
