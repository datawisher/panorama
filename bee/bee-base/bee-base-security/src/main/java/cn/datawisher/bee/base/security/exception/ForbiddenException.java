package cn.datawisher.bee.base.security.exception;

import cn.datawisher.bee.base.security.component.BeeAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * @author h407644
 * @date 2021-06-22
 */
@JsonSerialize(using = BeeAuth2ExceptionSerializer.class)
public class ForbiddenException extends BeeAuth2Exception{

    public ForbiddenException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }
}
