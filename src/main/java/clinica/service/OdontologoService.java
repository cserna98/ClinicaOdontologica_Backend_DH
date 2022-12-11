package clinica.service;

import clinica.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clinica.repository.OdontologoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> listarOdontolgoos(){
        return odontologoRepository.findAll();
    }

    public void modificarodontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public Optional<Odontologo> buscarOdontologo(Long id) {
        return odontologoRepository.findById(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
}
