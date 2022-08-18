package org.charles.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "hello");
        return "index";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
