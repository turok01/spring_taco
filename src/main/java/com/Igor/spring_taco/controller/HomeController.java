package com.Igor.spring_taco.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //dentify this class as a component for component scanning
//similar to  @Component, @Service, and @Repository
public class HomeController {
    @GetMapping("/") //if an HTTP GET request is received for the root path /,  then this method should handle that request
    public String home(){
        return "home";
    }
}
