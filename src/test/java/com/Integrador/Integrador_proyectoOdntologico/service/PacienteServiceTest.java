package com.Integrador.Integrador_proyectoOdntologico.service;

import com.Integrador.Integrador_proyectoOdntologico.entity.Domicilio;
import com.Integrador.Integrador_proyectoOdntologico.entity.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {
    private PacienteService pacienteService;

    @Autowired
    public PacienteServiceTest(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Paciente pacienteAGuardar= new Paciente("Serna",
                "cris","Criserlo98@gmail.com","dsfdsf",LocalDate.of(2022,11,28),new Domicilio("Calle a",454,"Salta capital",
                "Salta"));
        Paciente pacienteGuardado=pacienteService.guardarPaciente(pacienteAGuardar);
        assertEquals(3L,pacienteGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarPacientePorIDTest(){
        Long idABuscar=1L;
        Optional<Paciente> pacienteBuscado=pacienteService.buscarpaciente(idABuscar);
        assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void buscarPacientesTest(){
        List<Paciente> pacientes=pacienteService.buscarPacientes();
        assertEquals(1,pacientes.size());
    }
    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Paciente pacienteAActualizar= new Paciente(1L,"Serna", "cris","Criserlo198@gmail.com","dsfdsf",LocalDate.of(2022,11,28),
                new Domicilio("Calle a",454,"Salta capital", "Salta"));
        pacienteService.actualizarPaciente(pacienteAActualizar);
        Optional<Paciente> pacienteActualizado=pacienteService.buscarpaciente(1L);
        assertEquals("Criserlo198@gmail.com",pacienteActualizado.get().getEmail());
    }
    @Test
    @Order(5)
    public void eliminarPacienteTest(){
        Long idAEliminar=1L;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminado=pacienteService.buscarpaciente(idAEliminar);
        assertFalse(pacienteEliminado.isPresent());
    }

}
