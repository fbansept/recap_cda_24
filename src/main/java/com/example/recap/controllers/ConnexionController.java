package com.example.recap.controllers;


import com.example.recap.dao.UtilisateurDao;
import com.example.recap.models.Role;
import com.example.recap.models.Utilisateur;
import com.example.recap.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ConnexionController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/inscription")
    public String inscription(@RequestBody Utilisateur utilisateur) {

        Role roleUtilisateur = new Role();
        roleUtilisateur.setId(1);
        utilisateur.getListeRole().add(roleUtilisateur);
        String motDePasseClair = utilisateur.getPwd();
        String motDePasseHashe = bCryptPasswordEncoder.encode(motDePasseClair);
        utilisateur.setPwd(motDePasseHashe);

        utilisateurDao.save(utilisateur);

        return "OK";

    }

    @PostMapping("/connexion")
    public String connexion(@RequestBody Utilisateur utilisateur) {

        try {

            UserDetails userDetails = (UserDetails) authenticationProvider
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(utilisateur.getCodeClient(), utilisateur.getPwd()))
                    .getPrincipal();

            return jwtUtils.genererJwt(userDetails);

        } catch (Exception ex) {
            return "Erreur";
        }
    }

}
