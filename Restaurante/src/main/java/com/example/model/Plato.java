package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPlato;

    private String nombre;
    private Double precio;

    @ManyToOne
    private TipoPlato tipoPlato;

    @ManyToMany(mappedBy = "platos")
    private Set<Cocinero> cocineros = new HashSet<>();

    @ManyToMany(mappedBy = "platos")
    private Set<Ingrediente> ingredientes = new HashSet<>();

    public Plato() {
    }

    public Plato(String nombre, Double precio, TipoPlato tipoPlato) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoPlato = tipoPlato;
    }

    public TipoPlato getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<Cocinero> getCocineros() {
        return cocineros;
    }

    public void setCocineros(Set<Cocinero> cocineros) {
        this.cocineros = cocineros;
    }

    public Long getCodPlato() {
        return codPlato;
    }

    public void setCodPlato(Long codPlato) {
        this.codPlato = codPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "codPlato=" + codPlato +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
