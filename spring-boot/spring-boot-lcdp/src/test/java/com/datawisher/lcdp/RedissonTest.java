package com.datawisher.lcdp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author h407644
 * @date 2021-06-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = LcdpApplication.class,
        properties = {
                "spring.redis.timeout=10000"
        })
public class RedissonTest {

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private RedisTemplate<String, String> template;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testRedissonAutoConfiguration() {
        redisson.getKeys().flushall();

        RMap<String, String> m = redisson.getMap("test", StringCodec.INSTANCE);
        m.put("1", "ab");

        BoundHashOperations<String, String, String> hash = template.boundHashOps("test");
        String t = hash.get("1");
        assertThat(t).isEqualTo("ab");
    }

    @Test
    public void testRedissonCacheManagerAutoConfiguration() {
        Cache cache = cacheManager.getCache("test");
        Assert.assertNotNull(cache);
    }
}
