package com.example.model;

import jakarta.persistence.*;

@Entity
public class Estante {

    @Id
    private String letras;


    @ManyToOne
    private Almacen almacen;

    private Integer tamanio;


    public Estante() {
    }

    public Estante(String letras, Almacen almacen, Integer tamanio) {
        this.letras = letras;
        this.almacen = almacen;
        this.tamanio = tamanio;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Estante{" +
                "letras='" + letras + '\'' +
                ", almacen=" + almacen +
                ", tamanio=" + tamanio +
                '}';
    }
}
