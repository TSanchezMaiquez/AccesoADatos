package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tipo {

    @Id
    private String modelo;
    private Double capacidad;
    private Integer peso;

    @ManyToMany(mappedBy = "tipos")
    private Set<Mecanico> mecanicos = new HashSet<>();
    @ManyToMany(mappedBy = "tipos")
    private Set<Piloto> pilotos = new HashSet<>();

    public Tipo() {
    }

    public Tipo(String modelo, Double capacidad, Integer peso) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.peso = peso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String tipo) {
        this.modelo = tipo;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "tipo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", peso=" + peso +
                ", pilotos=" + pilotos +
                '}';
    }
}
