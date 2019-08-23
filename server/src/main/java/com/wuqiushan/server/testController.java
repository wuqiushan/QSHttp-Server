package com.wuqiushan.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @ResponseBody
    @RequestMapping("/test/api")
    public String testAPI() {
        return "test";
    }
}
