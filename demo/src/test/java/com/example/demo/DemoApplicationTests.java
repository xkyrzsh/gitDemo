package com.example.demo;

import com.example.demo.controller.DemoController;
import com.example.demo.mapper.UserMapper;
import com.example.demo.po.Person;
import com.example.demo.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Autowired
    Person person;

    @Value("${spring.dataSource.url}")
    String address;

    @Test
    void contextLoads() {
        List<User> list = userMapper.listUser();
        for(User user : list){
            System.out.println(user.toString());
        }
    }

    @Test
    void userTest(){
        List<User> list = userMapper.listUser();
        for(User user : list){
            System.out.println(user.getName());
        }
    }

    @Test
    void PersonTest(){
        System.out.println(person.toString());
    }

}
