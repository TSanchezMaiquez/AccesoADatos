package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Propietario extends Persona{

    private String telefono;

    @ManyToMany
    @JoinTable(
            name = "compra",
            joinColumns = @JoinColumn(name = "nss_propietario"),
            inverseJoinColumns = @JoinColumn(name = "n_registro_avion")
    )
    private Set<Avion> aviones = new HashSet<>();

    public Propietario() {

    }

    public Propietario(String nss, String nombre, String direccion, String telefono) {
        super(nss, nombre, direccion);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Set<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "telefono='" + telefono + '\'' +
                '}';
    }
}
