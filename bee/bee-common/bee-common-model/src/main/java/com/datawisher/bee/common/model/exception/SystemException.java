package com.datawisher.bee.common.model.exception;

import com.datawisher.bee.common.model.constant.StatusCode;
import com.datawisher.bee.common.model.util.MessageUtils;

/**
 * System服务应用异常
 *
 * @author h407644
 * @date 2022-09-12
 */
public class SystemException extends Exception{

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(StatusCode code, Throwable cause) {
        super(MessageUtils.getMsg(code), cause);
    }

}
