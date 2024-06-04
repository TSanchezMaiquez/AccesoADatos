package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Socio extends Persona{

    private LocalDate fechaAlta;
    private Double cuotaAnual;
    private Double cuotaMensual;

    @ManyToMany
    @JoinTable(
            name = "socios_proyectos",
            joinColumns = @JoinColumn(name = "num_afil_socio"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id")
    )
    private Set<Proyecto> proyectos = new HashSet<>();

    public Socio() {
    }

    public Socio(String dni, String nombre, String apellidos, String direccion, Asociacion asociacion, LocalDate fechaAlta, Double cuotaMensual) {
        super(dni, nombre, apellidos, direccion, asociacion);
        this.fechaAlta = fechaAlta;
        this.cuotaMensual = cuotaMensual;
        this.cuotaAnual = cuotaMensual*12;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getCuotaAnual() {
        return cuotaAnual;
    }

    public void setCuotaAnual(Double cuotaAnual) {
        this.cuotaAnual = cuotaAnual;
    }

    public Double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(Double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "fechaAlta=" + fechaAlta +
                ", cuotaAnual=" + cuotaAnual +
                ", cuotaMensual=" + cuotaMensual +
                '}';
    }
}
