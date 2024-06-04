package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "pistas_alquiladas_por_socio")
public class Reserva {

    @Id
    @Column(name= "dni_socio", insertable = false, updatable = false)
    private String dniSocio;

    @Id
    @Column(name= "num_pista", insertable = false, updatable = false)
    private Long numPista;

    @Id
    private LocalDate fecha;

    @Id
    private LocalTime hora;

    public Reserva() {
    }

    public Reserva(String dniSocio, Long numPista, LocalDate fecha, LocalTime hora) {
        this.dniSocio = dniSocio;
        this.numPista = numPista;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getDniSocio() {
        return dniSocio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "dniSocio='" + dniSocio + '\'' +
                ", numPista=" + numPista +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }

    public void setDniSocio(String dniSocio) {
        this.dniSocio = dniSocio;
    }

    public Long getNumPista() {
        return numPista;
    }

    public void setNumPista(Long numPista) {
        this.numPista = numPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
