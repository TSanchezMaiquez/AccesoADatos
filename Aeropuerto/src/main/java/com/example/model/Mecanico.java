package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Mecanico extends Persona{

    private String turno;
    private double salario;

    @ManyToMany
    @JoinTable(
            name = "mantiene",
            joinColumns = @JoinColumn(name = "nss_mecanico"),
            inverseJoinColumns = @JoinColumn(name = "n_registro_avion")
    )
    private Set<Avion> avionesReparados = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cualificado",
            joinColumns = @JoinColumn(name = "nss_mecanico"),
            inverseJoinColumns = @JoinColumn(name = "tipo_modelo")
    )
    private Set<Tipo> tipos = new HashSet<>();
    public Mecanico() {

    }

     public Mecanico(String nss, String nombre, String direccion, String turno, double salario) {
         super(nss, nombre, direccion);
         this.turno = turno;
         this.salario = salario;
     }

    public Set<Avion> getAvionesReparados() {
        return avionesReparados;
    }

    public void setAvionesReparados(Set<Avion> avionesReparados) {
        this.avionesReparados = avionesReparados;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Set<Avion> getAviones() {
        return avionesReparados;
    }

    public void setAviones(Set<Avion> aviones) {
        this.avionesReparados = aviones;
    }

    public String getTurno() {
         return turno;
     }

     public void setTurno(String turno) {
         this.turno = turno;
     }

     public double getSalario() {
         return salario;
     }

     public void setSalario(double salario) {
         this.salario = salario;
     }

     @Override
     public String toString() {
         return "Mecanico{" +
                 "turno=" + turno +
                 ", salario=" + salario +
                 '}';
     }
 }
