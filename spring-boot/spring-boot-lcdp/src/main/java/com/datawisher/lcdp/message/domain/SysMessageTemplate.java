package com.datawisher.lcdp.message.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.datawisher.lcdp.common.entity.LcdpEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author h407644
 * @date 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_msg_template")
public class SysMessageTemplate extends LcdpEntity {

    @ApiModelProperty(value = "模板CODE")
    private String code;
    @ApiModelProperty(value = "模板标题")
    private String name;
    @ApiModelProperty(value = "模板内容")
    private String content;
    @ApiModelProperty(value = "模板类型")
    private String type;
    @ApiModelProperty(value = "模板测试json")
    private String testJson;

}
