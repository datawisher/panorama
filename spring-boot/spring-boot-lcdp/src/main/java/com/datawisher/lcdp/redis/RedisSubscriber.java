package com.datawisher.lcdp.redis;

import cn.hutool.core.util.ObjectUtil;
import com.datawisher.lcdp.constant.GlobalConstants;
import com.datawisher.lcdp.redis.listener.LcdpRedisListener;
import com.datawisher.lcdp.util.SpringContextHolder;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * redis 订阅者
 *
 * @author h407644
 * @date 2021-05-28
 */
@Component
public class RedisSubscriber {

    /**
     * 接受消息并调用业务逻辑处理器
     *
     * @param params
     */
    public void onMessage(Map<String, Object> params) {
        String handlerName = params.get(GlobalConstants.HANDLER_NAME).toString();
        LcdpRedisListener messageListener = SpringContextHolder
                .getHandler(handlerName, LcdpRedisListener.class);
        if (ObjectUtil.isNotEmpty(messageListener)) {
            messageListener.onMessage(params);
        }
    }
}
