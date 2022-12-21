package com.Integrador.Integrador_proyectoOdntologico.service;

import com.Integrador.Integrador_proyectoOdntologico.entity.Odontologo;
import com.Integrador.Integrador_proyectoOdntologico.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private static final Logger LOGGER= Logger.getLogger(OdontologoService.class);
    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        LOGGER.info("Se inició el proceso de guardado del odontologo con apellido: "+
                odontologo.getApellido());
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
