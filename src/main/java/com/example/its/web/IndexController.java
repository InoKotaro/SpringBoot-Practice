package com.example.its.web;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    //GetMappongでトップページと関連させる
    @GetMapping("/")
    
    public String index() {
        return "index";
    }
}