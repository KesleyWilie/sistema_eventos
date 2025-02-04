package com.sistema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registro")
    public String registroPage() {
        return "registro/escolha";
    }
}