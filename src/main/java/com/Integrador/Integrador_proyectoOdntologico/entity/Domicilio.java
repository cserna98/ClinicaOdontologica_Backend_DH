package com.Integrador.Integrador_proyectoOdntologico.entity;

import javax.persistence.*;


@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String calle;
    @Column
    private Integer number;
    @Column
    private String localidad;
    @Column
    private String provincia;

    public Domicilio(Long id, String calle, Integer number, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.number = number;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, Integer number, String localidad, String provincia) {
        this.calle = calle;
        this.number = number;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Domicilio() {
    }
}
