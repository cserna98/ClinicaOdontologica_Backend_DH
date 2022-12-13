package com.Integrador.Integrador_proyectoOdntologico.controller;

import com.Integrador.Integrador_proyectoOdntologico.dto.TurnoDTO;
import com.Integrador.Integrador_proyectoOdntologico.entity.Odontologo;
import com.Integrador.Integrador_proyectoOdntologico.entity.Paciente;
import com.Integrador.Integrador_proyectoOdntologico.excepciones.BadRequestException;
import com.Integrador.Integrador_proyectoOdntologico.excepciones.ResourceNotFoundException;
import com.Integrador.Integrador_proyectoOdntologico.service.OdontologoService;
import com.Integrador.Integrador_proyectoOdntologico.service.PacienteService;
import com.Integrador.Integrador_proyectoOdntologico.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }




    @PostMapping
    public ResponseEntity<String> crearTurno(TurnoDTO turno) throws BadRequestException {
        Optional<Odontologo> odontoBuscado=odontologoService.buscarOdontologo(turno.getOdontologoId());
        Optional<Paciente> pacienteBuscado=pacienteService.buscarpaciente(turno.getPacienteId());
        if (odontoBuscado.isPresent()&&pacienteBuscado.isPresent()){
            turnoService.guardarTurno(turno);
            return ResponseEntity.ok().body("Se registro el turno :" + turno );
        }else if(odontoBuscado.isPresent()){
            throw new BadRequestException("No se encontro el paciente con id:"+ turno.getPacienteId());
        }else {
            throw new BadRequestException("No se encontro el odontologo con id:"+ turno.getOdontologoId());
        }

    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarturnos());
    }

    @PutMapping
    public   ResponseEntity<String> modificarTurno(TurnoDTO turnoDTO){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(turnoDTO.getId());
        if (turnoBuscado.isPresent()){
            turnoService.actualizarTurno(turnoDTO);
            return ResponseEntity.ok("se actualizo el turno con id: " + turnoDTO.getId() );
        }else {
            return ResponseEntity.badRequest().body("no existe el turno con id: "+ turnoDTO.getId());
        }
    }

    @GetMapping("/{id}")
    public   ResponseEntity<TurnoDTO> mostrarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarturno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("se elimino el turno con id: " + id);
        }else {
            throw new ResourceNotFoundException("No se puede eliminar el turno" +" con id= "+id);
        }
    }

}
