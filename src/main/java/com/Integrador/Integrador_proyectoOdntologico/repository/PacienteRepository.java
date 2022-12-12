package com.Integrador.Integrador_proyectoOdntologico.repository;

import com.Integrador.Integrador_proyectoOdntologico.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
