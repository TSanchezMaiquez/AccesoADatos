package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Socio {
    @Id
    private String dni;
    private String observaciones;
    private String nombre;
    private String Apellidos;
    private String direccion;
    private LocalDate fechaAlta;

    private String socioDependiente;

    @OneToMany
    @JoinTable(
            name = "amigos",
            joinColumns = @JoinColumn(name = "dni_socio"),
            inverseJoinColumns = @JoinColumn(name = "dni_amigo")
    )
    private Set<Socio> amigos = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "pistas_alquiladas_por_socio",
            joinColumns = @JoinColumn(name = "dni_socio"),
            inverseJoinColumns = @JoinColumn(name = "num_pista")
    )
    private Set<Pista> pistas = new HashSet<>();

    public Socio() {

    }

    public Socio(String dni, String observaciones, String nombre, String apellidos, String direccion, LocalDate fechaAlta, String socio) {
        this.dni = dni;
        this.observaciones = observaciones;
        this.nombre = nombre;
        Apellidos = apellidos;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.socioDependiente= socio;
    }

    public String getSocioDependiente() {
        return socioDependiente;
    }

    public void setSocioDependiente(String socioDependiente) {
        this.socioDependiente = socioDependiente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Pista> getPistas() {
        return pistas;
    }

    public void setPistas(Set<Pista> pistas) {
        this.pistas = pistas;
    }

    public Set<Socio> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Socio> socios) {
        this.amigos = socios;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "dni='" + dni + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
