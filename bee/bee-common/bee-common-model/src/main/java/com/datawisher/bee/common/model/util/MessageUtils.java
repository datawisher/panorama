package com.datawisher.bee.common.model.util;

import com.datawisher.bee.common.model.constant.StatusCode;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author h407644
 * @date 2022-09-13
 */
public class MessageUtils {

    public static String getMsg(StatusCode code) {
        try {
            MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
            return messageSource.getMessage(String.valueOf(code.getCode()), null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return String.valueOf(code.getCode());
        }
    }

    public static String getMsg(String code) {
        try {
            MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return code;
        }
    }

    public static String getMsg(int code) {
        try {
            MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
            return messageSource.getMessage(String.valueOf(code), null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return String.valueOf(code);
        }
    }

}
