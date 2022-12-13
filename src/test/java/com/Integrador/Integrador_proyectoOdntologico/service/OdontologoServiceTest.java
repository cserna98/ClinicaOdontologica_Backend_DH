package com.Integrador.Integrador_proyectoOdntologico.service;


import com.Integrador.Integrador_proyectoOdntologico.entity.Odontologo;

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
public class OdontologoServiceTest {
    private OdontologoService odontologoService;

    @Autowired

    public OdontologoServiceTest(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Odontologo OdontologoAGuardar= new Odontologo("ddd","fdfd","fdd");
        Odontologo odontologoGuardado=odontologoService.guardarOdontologo(OdontologoAGuardar);
        assertEquals(1L,odontologoGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarOdontologoPorIDTest(){
        Long idABuscar=1L;
        Optional<Odontologo> pacienteBuscado=odontologoService.buscarOdontologo(idABuscar);
        assertNotNull(pacienteBuscado.get());
    }
    @Test
    @Order(3)
    public void buscarOdontologoTest(){
        List<Odontologo> odontologos=odontologoService.listarOdontolgoos();
        assertEquals(1,odontologos.size());
    }
    @Test
    @Order(4)
    public void actualizarOdontologoTest(){
        Odontologo odontologoAActualizar= new Odontologo(1L,"ddd","fdfd","fdd");
        odontologoService.actualizarOdontologo(odontologoAActualizar);
        Optional<Odontologo> OdontologoActualizado=odontologoService.buscarOdontologo(1L);
        assertEquals("fdfd",OdontologoActualizado.get().getNombre());
    }
    @Test
    @Order(5)
    public void eliminarPacienteTest(){
        Long idAEliminar=1L;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoEliminado=odontologoService.buscarOdontologo(idAEliminar);
        assertFalse(odontologoEliminado.isPresent());
    }


}
