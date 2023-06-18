package com.pnb.authbackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/")
    public String helloUserController(){
        return "Admin access level";
    }
}
