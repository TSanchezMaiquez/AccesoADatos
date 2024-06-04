package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "compra")
public class Compra {

    @Id
    @Column(name= "nss_propietario", insertable = false, updatable = false)
    private String nssPro;

    @Id
    @Column(name= "n_registro_avion", insertable = false, updatable = false)
    private String nRegistroAvion;

    private LocalDate fechCompra;

    public Compra() {
    }

    public Compra(String nssPro, String nRegistroAvion, LocalDate fechCompra) {
        this.nssPro = nssPro;
        this.nRegistroAvion = nRegistroAvion;
        this.fechCompra = fechCompra;
    }

    public String getNssPro() {
        return nssPro;
    }

    public void setNssPro(String nssPro) {
        this.nssPro = nssPro;
    }

    public String getnRegistroAvion() {
        return nRegistroAvion;
    }

    public void setnRegistroAvion(String nRegistroAvion) {
        this.nRegistroAvion = nRegistroAvion;
    }

    public LocalDate getFechCompra() {
        return fechCompra;
    }

    public void setFechCompra(LocalDate fechCompra) {
        this.fechCompra = fechCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "nssPro='" + nssPro + '\'' +
                ", nRegistroAvion='" + nRegistroAvion + '\'' +
                ", fechCompra=" + fechCompra +
                '}';
    }
}
