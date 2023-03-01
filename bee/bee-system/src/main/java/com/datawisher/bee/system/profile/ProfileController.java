package com.datawisher.bee.system.profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.datawisher.bee.common.model.dto.Result;

/**
 * @author h407644
 * @date 2023-01-29
 */
@RestController
@RequestMapping("/api/sys/profile")
public class ProfileController {

    public static final String jsonResult = "{\n" +
            "    \"success\":true,\n" +
            "    \"code\":200,\n" +
            "    \"data\":{\n" +
            "        \"role\":[\n" +
            "            {\n" +
            "                \"id\":\"1\",\n" +
            "                \"title\":\"超级管理员\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"_id\":\"612710a0ec87aa543c9c341d\",\n" +
            "        \"id\":\"0\",\n" +
            "        \"username\":\"super-admin\",\n" +
            "        \"title\":\"超级管理员\",\n" +
            "        \"avatar\":\"https://m.imooc.com/static/wap/static/common/img/logo-small@2x.png\",\n" +
            "        \"permission\":{\n" +
            "            \"menus\":[\n" +
            "                \"userManage\",\n" +
            "                \"roleList\",\n" +
            "                \"permissionList\",\n" +
            "                \"articleRanking\",\n" +
            "                \"articleCreate\"\n" +
            "            ],\n" +
            "            \"points\":[\n" +
            "                \"distributeRole\",\n" +
            "                \"importUser\",\n" +
            "                \"removeUser\",\n" +
            "                \"distributePermission\"\n" +
            "            ]\n" +
            "        }\n" +
            "    },\n" +
            "    \"message\":\"获取资料成功\"\n" +
            "}";

    @GetMapping
    public JSONObject profile(@RequestParam(required = false) String token) {
        return JSONObject.parseObject(jsonResult);
    }

}
