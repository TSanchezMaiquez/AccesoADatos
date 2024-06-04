package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "mantiene")
public class Mantiene {

    @Id
    @Column(name= "nss_mecanico", insertable = false, updatable = false)
    private String nssMec;

    @Id
    @Column(name= "n_registro_avion", insertable = false, updatable = false)
    private String nRegistroAvion;

    @Id
    private String codTrabajo;

    private LocalDate fechaRep;

    private Integer numHoras;

    public Mantiene() {
    }

    public Mantiene(String nssMec, String nRegistroAvion, String codTrabajo, LocalDate fechaRep, Integer numHoras) {
        this.nssMec = nssMec;
        this.nRegistroAvion = nRegistroAvion;
        this.codTrabajo = codTrabajo;
        this.fechaRep = fechaRep;
        this.numHoras = numHoras;
    }

    public String getNssMec() {
        return nssMec;
    }

    public void setNssMec(String nssPro) {
        this.nssMec = nssPro;
    }

    public String getnRegistroAvion() {
        return nRegistroAvion;
    }

    public void setnRegistroAvion(String nRegistroAvion) {
        this.nRegistroAvion = nRegistroAvion;
    }

    public String getCodTrabajo() {
        return codTrabajo;
    }

    public void setCodTrabajo(String codTrabajo) {
        this.codTrabajo = codTrabajo;
    }

    public LocalDate getFechaRep() {
        return fechaRep;
    }

    public void setFechaRep(LocalDate fechaRep) {
        this.fechaRep = fechaRep;
    }

    public Integer getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Integer numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public String toString() {
        return "Mantiene{" +
                "nssPro='" + nssMec + '\'' +
                ", nRegistroAvion='" + nRegistroAvion + '\'' +
                ", codTrabajo='" + codTrabajo + '\'' +
                ", fechaRep=" + fechaRep +
                ", numHoras=" + numHoras +
                '}';
    }
}
