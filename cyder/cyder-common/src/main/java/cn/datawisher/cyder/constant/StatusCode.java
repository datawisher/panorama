package cn.datawisher.cyder.constant;

/**
 * 状态枚举类
 */
public enum StatusCode {

    OK(0),
    ERROR(1),

    USER_ADD_SUCCESS(10001),
    USER_ADD_ERROR(10002),
    USER_EDIT_SUCCESS(10003),
    USER_EDIT_ERROR(10004),
    USER_DELETE_SUCCESS(10005),
    USER_DELETE_ERROR(10006),
    USER_BATCH_DELETE_SUCCESS(10007),
    USER_BATCH_DELETE_ERROR(10008),
    ;

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
