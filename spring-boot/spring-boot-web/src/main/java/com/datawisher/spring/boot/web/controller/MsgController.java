package com.datawisher.spring.boot.web.controller;

import com.datawisher.spring.boot.starter.service.MsgService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @Resource
    private MsgService msgService;

    @RequestMapping("/send-msg")
    public String sendMsg() {
        msgService.sendMsg("测试短信");
        return "OK";
    }

}
