package cn.datawisher.cyder.system.user.constant;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 性别枚举类
 */
public enum AccountStatusEnum implements IEnum<Integer> {

    NORMAL(1,"正常"),

    LOCKED(2,"锁定"),
    FIRST(3,"首次注册"),

    ;

    private final Integer code;
    @JsonValue
    private final String name;

    AccountStatusEnum(Integer code, String name) {
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
