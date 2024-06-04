package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "tecnicos_y_tareas")
public class Participa {

    @Id
    @Column(name= "numTarea", insertable = false, updatable = false)
    private Long numTarea;

    @Id
    @Column(name= "codUsuario", insertable = false, updatable = false)
    private String codUsuario;

    private LocalDate fechaAct;

    private String rol;

    public Participa() {
    }

    public Participa(Long numTarea, String codUsuario, LocalDate fechaAct, String rol) {
        this.numTarea = numTarea;
        this.codUsuario = codUsuario;
        this.fechaAct = fechaAct;
        this.rol = rol;
    }

    public Long getNumTarea() {
        return numTarea;
    }

    public void setNumTarea(Long numTarea) {
        this.numTarea = numTarea;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public LocalDate getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(LocalDate fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Participa{" +
                "numTarea=" + numTarea +
                ", codUsuario='" + codUsuario + '\'' +
                ", fechaAct=" + fechaAct +
                ", rol='" + rol + '\'' +
                '}';
    }
}
