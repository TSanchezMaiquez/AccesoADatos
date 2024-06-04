package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Localizacion {
    @Id
    private String codLocalizacion;
    @Column(nullable = false)
    private String descripcion;

    private String direccion;

    private String pertenece;

    public Localizacion() {
    }

    public Localizacion(String codLocalizacion, String descripcion, String direccion, String pertenece) {
        this.codLocalizacion = codLocalizacion;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.pertenece = pertenece;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodLocalizacion() {
        return codLocalizacion;
    }

    public void setCodLocalizacion(String codLocalizacion) {
        this.codLocalizacion = codLocalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Localizacion{" +
                "codLocalizacion='" + codLocalizacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
