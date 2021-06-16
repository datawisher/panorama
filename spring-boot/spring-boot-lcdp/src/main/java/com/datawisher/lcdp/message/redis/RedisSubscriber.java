package com.datawisher.lcdp.message.redis;

import cn.hutool.core.util.ObjectUtil;
import com.datawisher.lcdp.message.constant.GlobalConstants;
import com.datawisher.lcdp.common.util.SpringContextHolder;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * redis 订阅者, 要在RedisConfig里注册监听类和监听方法
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
        RedisMessageListener messageListener = SpringContextHolder
                .getHandler(handlerName, RedisMessageListener.class);
        if (ObjectUtil.isNotEmpty(messageListener)) {
            messageListener.onMessage(params);
        }
    }
}
