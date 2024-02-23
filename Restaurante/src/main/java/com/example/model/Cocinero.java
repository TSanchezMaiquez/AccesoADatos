package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cocinero extends Empleado {
    
    private int añosServicio;

    private LocalDate fechaIngreso;

    @ManyToMany
    @JoinTable(
            name = "cocineros_y_sus_platos",
            joinColumns = @JoinColumn(name = "cocinero_dni"),
            inverseJoinColumns = @JoinColumn(name = "cod_plato")
    )
    private Set<Plato> platos = new HashSet<>();

    public Cocinero() {
    }

    public Cocinero(String dni, String nss, String nombre, String apellidos, LocalDate fechaIngreso) {
        super(dni, nss, nombre, apellidos);
        this.fechaIngreso = fechaIngreso;
        this.añosServicio = this.getAñosServicio();
    }

    public Set<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(Set<Plato> platos) {
        this.platos = platos;
    }

    public int getAñosServicio() {
        if (fechaIngreso != null) {
            LocalDate fechaActual = LocalDate.now();
            return Period.between(fechaIngreso, fechaActual).getYears();
        } else {
            return 0;
        }
    }

    public void setAñosServicio(int añosServicio) {
        this.añosServicio = añosServicio;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
