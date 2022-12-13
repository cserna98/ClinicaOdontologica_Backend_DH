package com.Integrador.Integrador_proyectoOdntologico.excepciones;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}