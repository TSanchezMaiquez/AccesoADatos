package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Asalariado extends Persona{

    private String nss;
    private Double sueldo;
    private String cargo;
    private String iban;
    private Double importeSS;

    @ManyToMany
    @JoinTable(
            name = "asalariados_proyectos",
            joinColumns = @JoinColumn(name = "num_afil_asalariado"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id")
    )
    private Set<Proyecto> proyectosAsalariados = new HashSet<>();

    public Asalariado() {
    }

    public Asalariado(String dni, String nombre, String apellidos, String direccion, Asociacion asociacion, String nss, Double sueldo, String cargo, String iban, Double importeSS) {
        super(dni, nombre, apellidos, direccion, asociacion);
        this.nss = nss;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.iban = iban;
        this.importeSS = importeSS;
    }

    public Set<Proyecto> getProyectosAsalariados() {
        return proyectosAsalariados;
    }

    public void setProyectosAsalariados(Set<Proyecto> proyectosAsalariados) {
        this.proyectosAsalariados = proyectosAsalariados;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getImporteSS() {
        return importeSS;
    }

    public void setImporteSS(Double importeSS) {
        this.importeSS = importeSS;
    }

    @Override
    public String toString() {
        return "Asalariado{" +
                "nss='" + nss + '\'' +
                ", sueldo=" + sueldo +
                ", cargo='" + cargo + '\'' +
                ", iban='" + iban + '\'' +
                ", importeSS=" + importeSS +
                '}';
    }
}
