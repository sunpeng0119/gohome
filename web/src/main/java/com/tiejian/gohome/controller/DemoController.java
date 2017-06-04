package com.tiejian.gohome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunpeng on 2017/6/4.
 */
@RestController
@RequestMapping(path = "demo")
public class DemoController {

    @RequestMapping(path = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello word !";
    }
}
