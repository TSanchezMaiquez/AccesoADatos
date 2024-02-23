package com.example.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Pinche extends Empleado{

    private LocalDate fechaNacimiento;
    private int edad;

    public Pinche() {
    }

    public Pinche(String dni, String nss, String nombre, String apellidos, LocalDate fechaNacimiento) {
        super(dni, nss, nombre, apellidos);
        this.fechaNacimiento = fechaNacimiento;
        this.edad = this.calcularEdad();
    }

    public int calcularEdad () {
        if (fechaNacimiento != null) {
            LocalDate fechaActual = LocalDate.now();
            return Period.between(fechaNacimiento, fechaActual).getYears();
        } else {
            return 0;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Pinche{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                '}';
    }
}
