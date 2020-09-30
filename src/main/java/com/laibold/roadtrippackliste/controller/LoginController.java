package com.laibold.roadtrippackliste.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @GetMapping("")
    public String loginGet(Model m) {
        m.addAttribute("value", dbUrl);
        return "login";
    }

}