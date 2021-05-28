package com.datawisher.lcdp.redis;

import com.datawisher.lcdp.constant.GlobalConstants;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 发布者
 */
@Component
public class RedisPublisher {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 发送消息
     *
     * @param bizName
     * @param params
     */
    public void sendMessage(String bizName, Map<String, Object> params) {
        params.put(GlobalConstants.HANDLER_NAME, bizName);
        redisTemplate.convertAndSend(GlobalConstants.REDIS_TOPIC_NAME, params);
    }


}
