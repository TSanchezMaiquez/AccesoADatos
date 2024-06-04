package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "asalariados_proyectos")
public class Participa {

    @Id
    @Column(name= "num_afil_asalariado", insertable = false, updatable = false)
    private Long numAfilAsalariado;

    @Id
    @Column(name= "proyecto_id", insertable = false, updatable = false)
    private Long proyectoId;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    public Participa() {
    }

    public Participa(Long numAfilAsalariado, Long proyectoId, LocalDate fechaInicio, LocalDate fechaFin, Rol rol) {
        this.numAfilAsalariado = numAfilAsalariado;
        this.proyectoId = proyectoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getNumAfilAsalariado() {
        return numAfilAsalariado;
    }

    public void setNumAfilAsalariado(Long numAfilAsalariado) {
        this.numAfilAsalariado = numAfilAsalariado;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Participa{" +
                "numAfilAsalariado=" + numAfilAsalariado +
                ", proyectoId=" + proyectoId +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
