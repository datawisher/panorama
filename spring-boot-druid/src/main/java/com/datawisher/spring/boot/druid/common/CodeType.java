package com.datawisher.spring.boot.druid.common;

public enum CodeType {

    OK(0, "success");

    private int code;
    private String value;

    CodeType(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
