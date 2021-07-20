package com.peng.cloudalibaba.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SentinelController {

    @GetMapping("/sentinel/testA")
    public String testA(){
        return "testA-----"+ DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
    }

    @GetMapping("/sentinel/testB")
    public String testB(){
        return "testB-----"+ DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
    }
}
