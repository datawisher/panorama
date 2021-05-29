package com.datawisher.lcdp.message.websocket;

import com.datawisher.lcdp.redis.RedisPublisher;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2021-05-27
 */
@Component
@Slf4j
@ServerEndpoint(value = "/websocket/{userId}") //此注解相当于设置访问URL
public class WebSocketServerEndpoint {

    @Autowired
    private RedisPublisher redisPublisher;

    private static final String MESSAGE_HANDLER = "webSocketMessageHandler";

    private Session session;
    private String userId;

    /**
     * 缓存 webSocket连接到单机服务class中（整体方案支持集群）
     */
    private static CopyOnWriteArraySet<WebSocketServerEndpoint> webSockets = new CopyOnWriteArraySet<>();
    private static Map<String, Session> sessionPool = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId") String userId) {
        try {
            this.session = session;
            this.userId = userId;
            webSockets.add(this);
            sessionPool.put(userId, session);
            log.info("【websocket消息】有新的连接，总数为:" + webSockets.size());
        } catch (Exception e) {
        }
    }

    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.userId);
            log.info("【websocket消息】连接断开，总数为:" + webSockets.size());
        } catch (Exception e) {
        }
    }

    @OnMessage
    public void onMessage(String message) {
        log.debug("【websocket消息】收到客户端消息:" + message);
        for (WebSocketServerEndpoint webSocket : webSockets) {
            webSocket.pushMessage(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("【websocket消息】发生错误", error);
    }

    /**
     * 服务端推送消息PojoEndpointBase
     *
     * @param message
     */
    public void pushMessage(String message) {
        try {
            webSockets.forEach(ws -> ws.session.getAsyncRemote().sendText(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端推送消息
     *
     * @param userId
     * @param message
     */
    public void pushMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        if (session != null && session.isOpen()) {
            try {
                log.info("【websocket消息】 单点消息:" + message);
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 后台发送消息到redis， 广播订阅消息
     *
     * @param message
     */
    public void sendMessage(String message) {
        log.info("【websocket消息】广播消息:" + message);
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "");
        params.put("message", message);
        redisPublisher.sendMessage(MESSAGE_HANDLER, params);
    }

    /**
     * 单点消息
     *
     * @param userId
     * @param message
     */
    public void sendMessage(String userId, String message) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("message", message);
        redisPublisher.sendMessage(MESSAGE_HANDLER, params);
    }

    /**
     * 此为单点消息(多人)
     *
     * @param userIds
     * @param message
     */
    public void sendMessage(String[] userIds, String message) {
        for (String userId : userIds) {
            sendMessage(userId, message);
        }
    }
}
