package clinica.controller;

import clinica.dto.TurnoDTO;
import clinica.entity.Turno;
import clinica.service.OdontologoService;
import clinica.service.PacienteService;
import clinica.service.TurnoService;
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
    public ResponseEntity<TurnoDTO> crearTurno(TurnoDTO turnodto){
        return ResponseEntity.ok(turnoService.guardarTurno(turnodto));
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
    public ResponseEntity<String> eliminarturno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("se elimino el turno con id: " + id);
        }else {
            return ResponseEntity.badRequest().body("no existe el turno con id: "+ id);
        }
    }

}
