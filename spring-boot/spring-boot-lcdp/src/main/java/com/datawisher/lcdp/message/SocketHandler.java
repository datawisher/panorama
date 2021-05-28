package com.datawisher.lcdp.message;

import cn.hutool.core.util.ObjectUtil;
import com.datawisher.lcdp.constant.CommonSendStatus;
import com.datawisher.lcdp.redis.listener.LcdpRedisListener;
import com.datawisher.lcdp.message.websocket.WebsocketServerEndpoint;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 监听消息(采用redis发布订阅方式发送消息)
 */
@Slf4j
@Component
public class SocketHandler implements LcdpRedisListener {

    @Autowired
    private WebsocketServerEndpoint websocket;

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