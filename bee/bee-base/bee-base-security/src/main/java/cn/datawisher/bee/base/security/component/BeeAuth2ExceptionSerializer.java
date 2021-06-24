package cn.datawisher.bee.base.security.component;

import cn.datawisher.bee.base.core.constant.CommonConstants;
import cn.datawisher.bee.base.security.exception.BeeAuth2Exception;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;

/**
 * @author h407644
 * @date 2021-06-22
 */
public class BeeAuth2ExceptionSerializer extends StdSerializer<BeeAuth2Exception> {
    public BeeAuth2ExceptionSerializer() {
        super(BeeAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(BeeAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
        gen.writeStartObject();
        gen.writeObjectField("code", CommonConstants.FAIL);
        gen.writeStringField("msg", value.getMessage());
        gen.writeStringField("data", value.getErrorCode());
        gen.writeEndObject();
    }
}
