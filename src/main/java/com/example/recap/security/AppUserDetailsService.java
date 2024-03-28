package com.example.recap.security;

import com.example.recap.dao.UtilisateurDao;
import com.example.recap.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurDao utilisateurDao;

    @Override
    public UserDetails loadUserByUsername(String codeClient) throws UsernameNotFoundException {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.trouveParCodeClient(codeClient);

        if(optionalUtilisateur.isEmpty()) {
            throw new UsernameNotFoundException("Code client introuvable");
        }

        return new AppUserDetails(optionalUtilisateur.get());
    }
}
