package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefono {

    @Id
    private String codTelefono;
    @Column(nullable = false)
    private String numTelefono;

    @ManyToOne
    private Usuario usuario;
    public Telefono() {
    }

    public Telefono(String codTelefono, String numTelefono, Usuario usuario) {
        this.codTelefono = codTelefono;
        this.numTelefono = numTelefono;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodTelefono() {
        return codTelefono;
    }

    public void setCodTelefono(String codTelefono) {
        this.codTelefono = codTelefono;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "codTelefono='" + codTelefono + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                '}';
    }
}
