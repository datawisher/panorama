package com.honeywell.mom.base.mongo.domain;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class Profile {

    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private Integer gender;

}
