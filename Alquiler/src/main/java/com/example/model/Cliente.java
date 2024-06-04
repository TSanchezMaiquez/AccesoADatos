package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    private String dni;


    private String nombre;


    private String apellidos;

    private String direccion;

    @ElementCollection
    private Set<String> telefono = new HashSet<>();

    private String email;

    private LocalDate fechaCaducidadCarnet;

    @ManyToMany
    @JoinTable(
            name = "coches_alquilados",
            joinColumns = @JoinColumn(name = "cliente_dni"),
            inverseJoinColumns = @JoinColumn(name = "matricula_coche")
    )
    private Set<Coche> coches = new HashSet<>();


    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, String email, LocalDate fechaCaducidadCarnet) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.fechaCaducidadCarnet = fechaCaducidadCarnet;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(Set<String> telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaCaducidadCarnet() {
        return fechaCaducidadCarnet;
    }

    public void setFechaCaducidadCarnet(LocalDate fechaCaducidadCarne) {
        this.fechaCaducidadCarnet = fechaCaducidadCarne;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", fechaCaducidadCarne=" + fechaCaducidadCarnet +
                '}';
    }
}
