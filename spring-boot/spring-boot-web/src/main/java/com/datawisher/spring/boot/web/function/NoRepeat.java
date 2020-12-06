package com.datawisher.spring.boot.web.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *  去重
 */
@Component
public class NoRepeat {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void noRepeatByRedis() {
        String KEY = "REQ12343456788";//请求唯一编号
        long expireTime =  1000;// 1000毫秒过期，1000ms内的重复请求会认为重复
        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;

        //redis key还存在的话要就认为请求是重复的
        Boolean firstSet = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> connection.set(KEY.getBytes(), val.getBytes(), Expiration
                .milliseconds(expireTime), RedisStringCommands.SetOption.SET_IF_ABSENT));

        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {// 第一次访问
            isConsiderDup = false;
        } else {// redis值已存在，认为是重复了
            isConsiderDup = true;
        }
    }
}
