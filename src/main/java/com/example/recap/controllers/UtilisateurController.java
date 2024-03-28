package com.example.recap.controllers;

import com.example.recap.dao.UtilisateurDao;
import com.example.recap.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/liste")
    public List<Utilisateur> liste () {
        return utilisateurDao.findAll();
    }
}
