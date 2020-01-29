package com.github.prgrms.socialserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CommonController2 {
    
    @RequestMapping("/2")
    public String root_test() throws Exception{
        return "Hello Root(/2)";
    }
 
    @RequestMapping("/demo2")
    public String demo_test() throws Exception{
        return "Hello demo(/demo2)";
    }
 
}


