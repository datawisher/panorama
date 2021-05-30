package com.datawisher.lcdp.message.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.datawisher.lcdp.common.entity.LcdpEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author h407644
 * @date 2021-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_msg")
public class SysMessage extends LcdpEntity {

}

