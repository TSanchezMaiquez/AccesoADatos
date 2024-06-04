package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pais;
    private Double beneficios;
    private String zona;
    private LocalDate fechaCierre;
    private Integer numAsalariados;
    @ManyToOne
    private Asociacion asociacion;

    public Proyecto() {
    }
    @ManyToMany(mappedBy = "proyectos")
    private Set<Socio> socios = new HashSet<>();

    @ManyToMany(mappedBy = "proyectosAsalariados")
    private Set<Asalariado> asalariados = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "objetivos_proyecto",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "objetivo_id")
    )
    private Set<Objetivo> objetivos = new HashSet<>();

    public Proyecto(String pais, Double beneficios, String zona, LocalDate fechaCierre, Integer numAsalariados, Asociacion asociacion) {
        this.pais = pais;
        this.beneficios = beneficios;
        this.zona = zona;
        this.fechaCierre = fechaCierre;
        this.numAsalariados = numAsalariados;
        this.asociacion = asociacion;
    }

    public Set<Objetivo> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(Set<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }

    public Set<Asalariado> getAsalariados() {
        return asalariados;
    }

    public void setAsalariados(Set<Asalariado> asalariados) {
        this.asalariados = asalariados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(Double beneficios) {
        this.beneficios = beneficios;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Integer getNumAsalariados() {
        return numAsalariados;
    }

    public void setNumAsalariados(Integer numAsalariados) {
        this.numAsalariados = numAsalariados;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", beneficios=" + beneficios +
                ", zona='" + zona + '\'' +
                ", fechaCierre=" + fechaCierre +
                ", numAsalariados=" + numAsalariados +
                '}';
    }
}
