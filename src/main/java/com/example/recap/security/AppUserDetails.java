package com.example.recap.security;

import com.example.recap.models.Role;
import com.example.recap.models.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {

    protected Utilisateur utilisateur;

    public AppUserDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<SimpleGrantedAuthority> listeRole = new ArrayList<>();

        for(Role role : utilisateur.getListeRole()) {
            listeRole.add(new SimpleGrantedAuthority("ROLE_" + role.getNom()));
        }

        return listeRole;
    }

    @Override
    public String getPassword() {
        return utilisateur.getPwd();
    }

    @Override
    public String getUsername() {
        return utilisateur.getCodeClient();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
