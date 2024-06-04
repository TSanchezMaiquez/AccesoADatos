package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "coches_alquilados")
public class Alquiler {

    @Id
    @Column(name= "cliente_dni", insertable = false, updatable = false)
    private String clienteDni;

    @Id
    @Column(name= "matricula_coche", insertable = false, updatable = false)
    private String matriculaCoche;

    @Id
    private LocalDate fechaInicio;

    @ElementCollection
    private List<String> desperfectos = new ArrayList<>();

    private LocalDate fechaDevolucion;

    private double kilometrosInicio;
    private double kilometrosFin;


    public Alquiler() {
    }

    public Alquiler(String clienteDni, String matriculaCoche, LocalDate fechaInicio, LocalDate fechaDevolucion, double kilometrosInicio, double kilometrosFin) {
        this.clienteDni = clienteDni;
        this.matriculaCoche = matriculaCoche;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
        this.kilometrosInicio = kilometrosInicio;
        this.kilometrosFin = kilometrosFin;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    public String getMatriculaCoche() {
        return matriculaCoche;
    }

    public void setMatriculaCoche(String matriculaCoche) {
        this.matriculaCoche = matriculaCoche;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<String> getDesperfectos() {
        return desperfectos;
    }

    public void setDesperfectos(List<String> desperfectos) {
        this.desperfectos = desperfectos;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getKilometrosInicio() {
        return kilometrosInicio;
    }

    public void setKilometrosInicio(double kilometrosInicio) {
        this.kilometrosInicio = kilometrosInicio;
    }

    public double getKilometrosFin() {
        return kilometrosFin;
    }

    public void setKilometrosFin(double kilometrosFin) {
        this.kilometrosFin = kilometrosFin;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "clienteDni='" + clienteDni + '\'' +
                ", matriculaCoche=" + matriculaCoche +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                ", kilometrosInicio=" + kilometrosInicio +
                ", kilometrosFin=" + kilometrosFin +
                '}';
    }
}
