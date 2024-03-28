package com.example.recap.dao;

import com.example.recap.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByCodeClient(String codeClient);

    @Query("FROM Utilisateur u JOIN FETCH u.listeRole r WHERE u.codeClient = :code")
    Optional<Utilisateur> trouveParCodeClient(@Param("code") String codeClient);

}
