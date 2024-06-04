package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Incidencia {

    @Id
    private String codIncidencia;

    @Column(nullable = false)
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private String solucion;
    @ManyToOne
    private Responsable responsable;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Localizacion localizacion;

    public Incidencia() {
    }

    public Incidencia(String codIncidencia, LocalDate fechaApertura, LocalDate fechaCierre, String solucion, Responsable responsable, Usuario usuario, Localizacion localizacion) {
        this.codIncidencia = codIncidencia;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.solucion = solucion;
        this.responsable = responsable;
        this.usuario = usuario;
        this.localizacion = localizacion;
    }

    public String getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(String codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "codIncidencia='" + codIncidencia + '\'' +
                ", fechaApertura=" + fechaApertura +
                ", fechaCierre=" + fechaCierre +
                ", solucion='" + solucion + '\'' +
                '}';
    }
}
