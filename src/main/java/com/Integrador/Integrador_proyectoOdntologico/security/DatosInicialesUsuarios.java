package com.Integrador.Integrador_proyectoOdntologico.security;

import com.Integrador.Integrador_proyectoOdntologico.entity.Usuario;
import com.Integrador.Integrador_proyectoOdntologico.entity.UsuarioRole;
import com.Integrador.Integrador_proyectoOdntologico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DatosInicialesUsuarios implements ApplicationRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //crear un usuario como si fuera real
        //guardarlo en la base
        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passSinCifrar="digital";
        String passCifrada=cifrador.encode(passSinCifrar);
        Usuario usuarioAInsertar=new Usuario("Rodolfo",
                "Rodolfo",
                "rebaspineiro@gmail.com",passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuarioAInsertar);
        //crear un usuario tipo admin
        String passCifrada2=cifrador.encode("house");
        usuarioAInsertar= new Usuario("Ezequiel","Ezequiel","admin@gmail.com",
                passCifrada2,UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuarioAInsertar);

    }
}

