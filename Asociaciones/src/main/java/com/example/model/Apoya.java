package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "socios_proyectos")
public class Apoya {

    @Id
    @Column(name= "num_afil_socio", insertable = false, updatable = false)
    private Long numAfilSocio;

    @Id
    @Column(name= "proyecto_id", insertable = false, updatable = false)
    private Long proyectoId;

    private LocalDate fecha;
    private Double importe;

    public Apoya() {
    }

    public Apoya(Long numAfilSocio, Long proyectoId, LocalDate fecha, Double importe) {
        this.numAfilSocio = numAfilSocio;
        this.proyectoId = proyectoId;
        this.fecha = fecha;
        this.importe = importe;
    }

    public Long getNumAfilSocio() {
        return numAfilSocio;
    }

    public void setNumAfilSocio(Long numAfilSocio) {
        this.numAfilSocio = numAfilSocio;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Apoya{" +
                "numAfilSocio=" + numAfilSocio +
                ", proyectoId=" + proyectoId +
                ", fecha=" + fecha +
                ", importe=" + importe +
                '}';
    }
}
