package com.example.web_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class langController {
    @GetMapping("lang")
    public String lang() {
        return "view/demoLanguage";
    }
}
