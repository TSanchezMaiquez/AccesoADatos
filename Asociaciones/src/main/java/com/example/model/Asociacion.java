package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.NaturalId;

@Entity
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    @NaturalId
    private String cif;
    private String denominacion;
    private String tipo;
    private String utilidad;

    public Asociacion() {
    }

    public Asociacion(String direccion, String cif, String denominacion, String tipo, String utilidad) {
        this.direccion = direccion;
        this.cif = cif;
        this.denominacion = denominacion;
        this.tipo = tipo;
        this.utilidad = utilidad;
    }

    @Override
    public String toString() {
        return "Asociacion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", cif='" + cif + '\'' +
                ", denominacion='" + denominacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", utilidad='" + utilidad + '\'' +
                '}';
    }
}
