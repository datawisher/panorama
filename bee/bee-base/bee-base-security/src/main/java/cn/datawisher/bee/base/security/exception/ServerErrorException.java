package cn.datawisher.bee.base.security.exception;

import cn.datawisher.bee.base.security.component.BeeAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * @author h407644
 * @date 2021-06-22
 */
@JsonSerialize(using = BeeAuth2ExceptionSerializer.class)
public class ServerErrorException extends BeeAuth2Exception{

    public ServerErrorException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "server_error";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
