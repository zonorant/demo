package com.example.demo.test;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private CacheTestService cacheTestService;

    @RequestMapping("list")
    public Object list() {
        return cacheTestService.getData("abc");
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
