package com.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nPista;

    private Double superficie;
    private String localizacion;
    private String estado;
    @ManyToMany(mappedBy = "pistas")
    private Set<Socio> socios = new HashSet<>();

    public Pista() {
    }

    public Pista(Double superficie, String localizacion, String estado) {
        this.superficie = superficie;
        this.localizacion = localizacion;
        this.estado = estado;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }

    public Long getnPista() {
        return nPista;
    }

    public void setnPista(Long nPista) {
        this.nPista = nPista;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pista{" +
                "nPista=" + nPista +
                ", superficie=" + superficie +
                ", localizacion='" + localizacion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
