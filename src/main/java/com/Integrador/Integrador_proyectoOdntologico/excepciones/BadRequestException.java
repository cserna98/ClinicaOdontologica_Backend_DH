package com.Integrador.Integrador_proyectoOdntologico.excepciones;

public class BadRequestException extends Exception{
    public BadRequestException(String mensaje) {
        super(mensaje);
    }
}
