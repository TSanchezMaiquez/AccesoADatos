package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTipo;
    private String descripcion;

    public TipoPlato() {
    }

    public TipoPlato(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Long codTipo) {
        this.codTipo = codTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoPlato{" +
                "codTipo=" + codTipo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
