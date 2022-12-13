package com.Integrador.Integrador_proyectoOdntologico.repository;

import com.Integrador.Integrador_proyectoOdntologico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
