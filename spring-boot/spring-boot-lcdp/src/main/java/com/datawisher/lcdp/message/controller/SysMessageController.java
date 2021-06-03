package com.datawisher.lcdp.message.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datawisher.lcdp.common.vo.Result;
import com.datawisher.lcdp.message.domain.SysMessage;
import com.datawisher.lcdp.message.service.ISysMessageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2021-06-01
 */
@RestController
@RequestMapping("/sys/message")
public class SysMessageController {

    @Autowired
    private ISysMessageService sysMessageService;

    @GetMapping("/list")
    public Result<?> queryPageList(SysMessage sysMessage,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            HttpServletRequest req) {
        QueryWrapper<SysMessage> queryWrapper = new QueryWrapper<>(sysMessage);
        Page<SysMessage> page = new Page<>(pageNo, pageSize);
        Page<SysMessage> pageList = sysMessageService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody SysMessage sysMessage) {
        sysMessageService.save(sysMessage);
        return Result.ok("添加成功！");
    }
}
