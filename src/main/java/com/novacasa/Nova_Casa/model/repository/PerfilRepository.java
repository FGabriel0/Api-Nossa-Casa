package com.novacasa.Nova_Casa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novacasa.Nova_Casa.model.entidy.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
