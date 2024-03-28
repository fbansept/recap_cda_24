package com.example.recap.controllers;

import com.example.recap.security.IsAdmin;
import com.example.recap.security.IsUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Le serveur marche !";
    }

    @GetMapping("/hello")
    public String helloAnonyme() {
        return "Bonjour anonyme!";
    }

    @GetMapping("/admin/hello")
    @IsAdmin
    public String helloAdmin() {
        return "Bonjour admin!";
    }

    @GetMapping("/user/hello")
    @IsUser
    public String helloUser() {
        return "Bonjour utilisateur !";
    }

}
