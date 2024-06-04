package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Avion {

    @Id
    private String nRegistro;

    private String matricula;
    private LocalDate fechaReg;

    private LocalDate fechaConstruccion;

    private LocalDate antiguedad;

    @ManyToMany(mappedBy = "aviones")
    private Set<Propietario> propietarios = new HashSet<>();

    @ManyToOne
    private Tipo tipo;

    @ManyToOne
    private Hangar hangar;

    @ManyToMany(mappedBy = "avionesReparados")
    private Set<Mecanico> mecanicos = new HashSet<>();


    public Avion() {
    }


    public Avion(String nRegistro, String matricula, LocalDate fechaReg, LocalDate fechaConstruccion, LocalDate antiguedad, Tipo tipo, Hangar hangar) {
        this.nRegistro = nRegistro;
        this.matricula = matricula;
        this.fechaReg = fechaReg;
        this.fechaConstruccion = fechaConstruccion;
        this.antiguedad = antiguedad;
        this.tipo = tipo;
        this.hangar = hangar;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Set<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(Set<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public String getnRegistro() {
        return nRegistro;
    }

    public void setnRegistro(String nRegistro) {
        this.nRegistro = nRegistro;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Set<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public LocalDate getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(LocalDate fechaReg) {
        this.fechaReg = fechaReg;
    }

    public LocalDate getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(LocalDate fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public LocalDate getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(LocalDate antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "nRegistro='" + nRegistro + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaReg=" + fechaReg +
                ", fechaConstruccion=" + fechaConstruccion +
                ", antiguedad=" + antiguedad +
                ", tipo=" + tipo +
                ", hangar=" + hangar +
                '}';
    }
}
