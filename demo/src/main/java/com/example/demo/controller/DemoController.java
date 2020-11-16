package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api("测试")
@Controller
@RequestMapping("/user")
public class DemoController {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Resource
    UserMapper userMapper;


    @RequestMapping(value="/html")
    public String getUserHtml(){
        return "/user/name";
    }

    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @RequestMapping(value="/info", method = RequestMethod.GET)
    @ResponseBody
//    @Transactional
    public String getUserInfo() {
//        String sql = "select * from user";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<User> list = userMapper.listUser();
        return list.get(0).toString()+"--port : 8081";
    }
}
