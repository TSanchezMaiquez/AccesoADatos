package com.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAfil;
    @NaturalId
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    @ManyToOne
    private Asociacion asociacion;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellidos, String direccion, Asociacion asociacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.asociacion = asociacion;
    }

    public Long getNumAfil() {
        return numAfil;
    }

    public void setNumAfil(Long numAfil) {
        this.numAfil = numAfil;
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

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "numAfil=" + numAfil +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
