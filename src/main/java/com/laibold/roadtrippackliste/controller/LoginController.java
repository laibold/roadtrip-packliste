package com.laibold.roadtrippackliste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String loginGet(Model m) {
        return "login";
    }

}