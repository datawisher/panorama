package com.datawisher.lcdp.message.controller;

import com.alibaba.fastjson.JSONObject;
import com.datawisher.lcdp.common.vo.Result;
import com.datawisher.lcdp.redis.RedisPublisher;
import com.datawisher.lcdp.constant.WebsocketConst;
import com.datawisher.lcdp.message.websocket.WebsocketServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2021-05-27
 */
@RestController
public class MessageController {

    @Autowired
    private RedisPublisher redisClient;
    @Autowired
    private WebsocketServerEndpoint websocketServerEndpoint;

    @RequestMapping("/send-message/{handlerName}")
    public String sendMessage(@PathVariable(name = "handlerName") String handlerName) {
        Map<String, Object> map = new HashMap<>();
        map.put("aa", 123);
        redisClient.sendMessage(handlerName, map);
        return "OK";
    }

    /**
     * 广播
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/send-all")
    public Result<String> sendAll(@RequestBody JSONObject jsonObject) {
        Result<String> result = new Result<>();
        String message = jsonObject.getString("message");
        JSONObject obj = new JSONObject();
        obj.put(WebsocketConst.MSG_CMD, WebsocketConst.CMD_TOPIC);
        obj.put(WebsocketConst.MSG_ID, "M0001");
        obj.put(WebsocketConst.MSG_TXT, message);
        websocketServerEndpoint.sendMessage(obj.toJSONString());
        result.setResult("群发！");
        return result;
    }

    /**
     * 指定用户
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/send-user")
    public Result<String> sendUser(@RequestBody JSONObject jsonObject) {
        Result<String> result = new Result<String>();
        String userId = jsonObject.getString("userId");
        String message = jsonObject.getString("message");
        JSONObject obj = new JSONObject();
        obj.put(WebsocketConst.MSG_CMD, WebsocketConst.CMD_USER);
        obj.put(WebsocketConst.MSG_USER_ID, userId);
        obj.put(WebsocketConst.MSG_ID, "M0001");
        obj.put(WebsocketConst.MSG_TXT, message);
        websocketServerEndpoint.sendMessage(userId, obj.toJSONString());
        result.setResult("单发");
        return result;
    }
}
