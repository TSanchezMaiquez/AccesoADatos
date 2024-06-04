package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numOrden;

    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "tecnicos_y_tareas",
            joinColumns = @JoinColumn(name = "numTarea"),
            inverseJoinColumns = @JoinColumn(name = "codUsuario")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();

    @ManyToOne
    private Incidencia incidencia;

    public Tarea() {
    }

    public Tarea(String descripcion, Incidencia incidencia) {
        this.descripcion = descripcion;
        this.incidencia = incidencia;
    }

    public Set<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Set<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Long getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Long numOrden) {
        this.numOrden = numOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "numOrden=" + numOrden +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
