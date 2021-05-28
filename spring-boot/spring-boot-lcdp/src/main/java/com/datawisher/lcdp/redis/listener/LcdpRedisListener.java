package com.datawisher.lcdp.redis.listener;

import java.util.Map;

/**
 * 自定义消息监听
 *
 * @author h407644
 * @date 2021-05-28
 */
public interface LcdpRedisListener {

    void onMessage(Map<String, Object> message);

}
