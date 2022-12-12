package clinica.controller;

import clinica.entity.Odontologo;
import clinica.entity.Paciente;
import clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import clinica.service.OdontologoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<Optional<Odontologo>> modificarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        if (odontologoBuscado.isPresent()){
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok(odontologoService.buscarOdontologo(odontologo.getId()));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>>  ListarOdontologo(){
        return ResponseEntity.ok(odontologoService.listarOdontolgoos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Se elimino el odontologo con id: "+id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> verOdontologo(@PathVariable long id){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologo(id);
        if (odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
