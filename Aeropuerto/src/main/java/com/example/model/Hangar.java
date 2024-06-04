package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hangar {

    @Id
    private String codHangar;

    private Integer capacidad;
    private String localizacion;

    public Hangar(String codHangar, Integer capacidad, String localizacion) {
        this.codHangar = codHangar;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    public Hangar() {
    }

    public String getCodHangar() {
        return codHangar;
    }

    public void setCodHangar(String codHangar) {
        this.codHangar = codHangar;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Hangar{" +
                "codHangar='" + codHangar + '\'' +
                ", capacidad=" + capacidad +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }
}
