package cn.datawisher.cyder.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import cn.datawisher.cyder.constant.StatusCode;

/**
 * I18n 消息处理工具
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
