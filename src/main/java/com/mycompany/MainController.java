package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("") // makes url
    public String showHomePage(){

        return "index"; // from templates html file returns that
    }

}
