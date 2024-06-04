package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tecnico extends Usuario{

    private LocalDate fechaAlta;
    @Column(nullable = false)
    private String Especialidad;

    @ManyToMany(mappedBy = "tecnicos")
    private Set<Tarea> tareas = new HashSet<>();

    public Tecnico() {
    }

    public Tecnico(String codUsuario, String login, String email1, String email2, String nombre, String apellidos, LocalDate fechaNac, LocalDate fechaAlta, String especialidad) {
        super(codUsuario, login, email1, email2, nombre, apellidos, fechaNac);
        this.fechaAlta = fechaAlta;
        Especialidad = especialidad;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString()+"Tecnico{" +
                "fechaAlta=" + fechaAlta +
                ", Especialidad='" + Especialidad + '\'' +
                '}';
    }
}
