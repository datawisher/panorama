package cn.datawisher.bee.base.security.exception;

import cn.datawisher.bee.base.security.component.BeeAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author h407644
 * @date 2021-06-22
 */
@JsonSerialize(using = BeeAuth2ExceptionSerializer.class)
public class BeeAuth2Exception extends OAuth2Exception {

    @Getter
    private String errorCode;

    public BeeAuth2Exception(String msg) {
        super(msg);
    }

    public BeeAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
