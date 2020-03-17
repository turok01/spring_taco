package com.Igor.spring_taco.controller;

import com.Igor.spring_taco.TempString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String testGetForm(Model model){
        String str = "stringFromGet";
        String str2 = "stringFromGet2";
        model.addAttribute("tempstringdata",new TempString());
        model.addAttribute("get_attribute2",str2);
        model.addAttribute("get_attribute3", 2 );
        return "test";
    }
    @PostMapping
    public String testPostForm(TempString tempString){
        log.info("Processing test Post " + tempString);

        return "home";
    }
}
