package com.Integrador.Integrador_proyectoOdntologico;

import com.Integrador.Integrador_proyectoOdntologico.dto.TurnoDTO;
import com.Integrador.Integrador_proyectoOdntologico.entity.Domicilio;
import com.Integrador.Integrador_proyectoOdntologico.entity.Odontologo;
import com.Integrador.Integrador_proyectoOdntologico.entity.Paciente;
import com.Integrador.Integrador_proyectoOdntologico.service.OdontologoService;
import com.Integrador.Integrador_proyectoOdntologico.service.PacienteService;
import com.Integrador.Integrador_proyectoOdntologico.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import  static org.junit.jupiter.api.Assertions.assertFalse;


import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    private void cargarDatos(){
        Paciente pacienteAgregado=pacienteService
                .guardarPaciente(new Paciente("Serna",
                        "cris","Criserlo98@gmail.com","dsfdsf",LocalDate.of(2022,11,28),new Domicilio("Calle a",454,"Salta capital",
                        "Salta")));
        Odontologo odontologoAgregado=odontologoService
                .guardarOdontologo(new Odontologo("DDFFH","cris","serna"));
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setFecha(LocalDate.of(2022,12,8));
        turnoDTO.setOdontologoId(odontologoAgregado.getId());
        turnoDTO.setPacienteId(pacienteAgregado.getId());
        turnoService.guardarTurno(turnoDTO);
    }
    @Test
    public void listarTurnosTest() throws Exception {
        cargarDatos();
        MvcResult respuesta=mockMvc.perform
                        (MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
