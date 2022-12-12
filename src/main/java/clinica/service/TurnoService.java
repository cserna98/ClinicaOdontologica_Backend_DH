package clinica.service;

import clinica.dto.TurnoDTO;
import clinica.entity.Odontologo;
import clinica.entity.Paciente;
import clinica.entity.Turno;
import clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnorepository;
    @Autowired
    public TurnoService(TurnoRepository turnorepository) {
        this.turnorepository = turnorepository;
    }

    public List<TurnoDTO> listarturnos(){
        List<Turno> turnosEncontrados=turnorepository.findAll();
        List<TurnoDTO> turnos = new ArrayList<>();
        for (Turno turno:turnosEncontrados){
            turnos.add(turnoATurnoDTO(turno));
        }
        return turnos;
    }

    public TurnoDTO guardarTurno(TurnoDTO turnoDTO){
         return turnoATurnoDTO(turnorepository.save(turnoDTOATurno(turnoDTO)));
    }

    public void eliminarTurno(Long id){
         turnorepository.deleteById(id);
    }

    public Optional<TurnoDTO> buscarTurno(Long id){
        Optional<Turno>  turnobuscado = turnorepository.findById(id);
        if (turnobuscado.isPresent()){
            return  Optional.of(turnoATurnoDTO(turnobuscado.get()));
        }else {
            return Optional.empty();
        }
    }

    public void actualizarTurno(TurnoDTO turnodto){
        turnorepository.save(turnoDTOATurno(turnodto));
    }

    private TurnoDTO turnoATurnoDTO(Turno turno){
        //convertir el turno a un turnoDTO
        TurnoDTO respuesta= new TurnoDTO();
        //cargar la información de turno al turno DTO
        respuesta.setId(turno.getId());
        respuesta.setPacienteId(turno.getPaciente().getId());
        respuesta.setOdontologoId(turno.getOdontologo().getId());
        respuesta.setFecha(turno.getFecha());
        //devolución
        return respuesta;
    }

    private Turno turnoDTOATurno(TurnoDTO turnodto){
        Turno respuesta= new Turno();
        //cargar la información de turno DTO al turno
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnodto.getOdontologoId());
        paciente.setId(turnodto.getPacienteId());
        respuesta.setFecha(turnodto.getFecha());
        respuesta.setId(turnodto.getId());
        //no debemos olvidarnos de agregar ambos objetos
        respuesta.setOdontologo(odontologo);
        respuesta.setPaciente(paciente);
        //salida
        return respuesta;
    }


}
