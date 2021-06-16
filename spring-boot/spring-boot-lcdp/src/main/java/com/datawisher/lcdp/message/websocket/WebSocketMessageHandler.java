package com.datawisher.lcdp.message.websocket;

import cn.hutool.core.util.ObjectUtil;
import com.datawisher.lcdp.message.constant.CommonSendStatus;
import com.datawisher.lcdp.message.redis.RedisMessageListener;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 监听消息(采用redis发布订阅方式发送消息)
 */
@Slf4j
@Component
public class WebSocketMessageHandler implements RedisMessageListener {

    @Autowired
    private WebSocketServerEndpoint websocket;

    @Override
    public void onMessage(Map<String, Object> map) {
        log.info("【SocketHandler消息】Redis Listener:" + map.toString());

        String userId = map.get("userId").toString();
        String message = map.get("message").toString();
        if (ObjectUtil.isNotEmpty(userId)) {
            websocket.pushMessage(userId, message);
            //app端消息推送
            websocket.pushMessage(userId + CommonSendStatus.APP_SESSION_SUFFIX, message);
        } else {
            websocket.pushMessage(message);
        }

    }
}