package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Coche {

    @Id
    private String matricula;

    private String descripcion;

    private String numeroBastidor;

    private double kilometrosActuales;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private TipoCoche tipoCoche;
    @ManyToMany(mappedBy = "coches")
    private Set<Cliente> clientes = new HashSet<>();

    public Coche() {
    }

    public Coche(String matricula, String descripcion, String numeroBastidor, double kilometrosActuales, Marca marca, TipoCoche tipoCoche) {
        this.descripcion = descripcion;
        this.matricula = matricula;
        this.numeroBastidor = numeroBastidor;
        this.kilometrosActuales = kilometrosActuales;
        this.marca = marca;
        this.tipoCoche = tipoCoche;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoCoche getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(TipoCoche tipoCoche) {
        this.tipoCoche = tipoCoche;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroBastidor() {
        return numeroBastidor;
    }

    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }

    public double getKilometrosActuales() {
        return kilometrosActuales;
    }

    public void setKilometrosActuales(double kilometrosActuales) {
        this.kilometrosActuales = kilometrosActuales;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroBastidor='" + numeroBastidor + '\'' +
                ", kilometrosActuales=" + kilometrosActuales +
                '}';
    }
}

