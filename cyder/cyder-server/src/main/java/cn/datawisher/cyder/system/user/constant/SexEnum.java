package cn.datawisher.cyder.system.user.constant;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 性别枚举类
 */
public enum SexEnum implements IEnum<Integer> {

    MAN(1,"男"),

    WOMAN(2,"女");

    private final Integer code;
    @JsonValue
    private final String name;

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    public String getName() {
        return name;
    }
}
