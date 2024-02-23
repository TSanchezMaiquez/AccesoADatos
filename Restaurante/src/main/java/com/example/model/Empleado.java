package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado {
    @Id
    private String dni;

    private String nss;

    private String nombre;

    private String apellidos;

    public Empleado() {
    }

    public Empleado(String dni, String nss, String nombre, String apellidos) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String nss) {
        this.dni = nss;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String dni) {
        this.nss = dni;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "nss='" + dni + '\'' +
                ", dni='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}

