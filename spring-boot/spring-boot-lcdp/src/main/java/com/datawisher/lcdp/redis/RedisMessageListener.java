package com.datawisher.lcdp.redis;

import java.util.Map;

/**
 * 自定义消息监听器
 *
 * @author h407644
 * @date 2021-05-28
 */
public interface RedisMessageListener {

    void onMessage(Map<String, Object> message);

}
