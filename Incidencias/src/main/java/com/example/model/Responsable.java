package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Responsable extends Usuario {

    @Column(nullable = false)
    private String cualificacion;
    @Column(nullable = false)
    private String descripcion;

    public Responsable() {
    }

    public Responsable(String codUsuario, String login, String email1, String email2, String nombre, String apellidos, LocalDate fechaNac, String cualificacion, String descripcion) {
        super(codUsuario, login, email1, email2, nombre, apellidos, fechaNac);
        this.cualificacion = cualificacion;
        this.descripcion = descripcion;
    }

    public String getCualificacion() {
        return cualificacion;
    }

    public void setCualificacion(String cualificacion) {
        this.cualificacion = cualificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString()+"Responsable{" +
                "cualificacion='" + cualificacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
