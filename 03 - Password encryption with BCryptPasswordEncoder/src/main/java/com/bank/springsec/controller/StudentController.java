package com.bank.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String home() {
        return "Welcome Home!!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin!!";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Welcome Contact!!";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "Welcome About Me!!";
    }


}
