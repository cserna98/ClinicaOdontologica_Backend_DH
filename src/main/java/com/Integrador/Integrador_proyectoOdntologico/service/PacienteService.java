package com.Integrador.Integrador_proyectoOdntologico.service;


import com.Integrador.Integrador_proyectoOdntologico.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Integrador.Integrador_proyectoOdntologico.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PacienteService {

    private static final Logger LOGGER= Logger.getLogger("log");
    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardarPaciente(Paciente paciente){
        LOGGER.info("Se inició el proceso de guardado del paciente :"+paciente.getId() );
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarpaciente(Long id){
        return pacienteRepository.findById(id);
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public List<Paciente> buscarPacientes(){
        return pacienteRepository.findAll();
    }

}
