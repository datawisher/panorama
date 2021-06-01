package com.datawisher.lcdp.message.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.datawisher.lcdp.common.entity.LcdpEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
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

    @ApiModelProperty(value = "消息标题")
    private String title;
    @ApiModelProperty(value = "推送内容")
    private String content;
    @ApiModelProperty(value = "推送方式：1短信 2邮件 3微信")
    private String type;
    @ApiModelProperty(value = "推送所需参数（JSON格式）")
    private String param;
    @ApiModelProperty(value = "接收人")
    private String receiver;
    @ApiModelProperty(value = "推送失败原因")
    private String result;
    @ApiModelProperty(value = "发送次数")
    private Integer sendNum;
    @ApiModelProperty(value = "推送状态 0未推送 1推送成功 2推送失败")
    private String sendStatus;
    @ApiModelProperty(value = "推送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
    @ApiModelProperty(value = "备注")
    private String remark;

}

