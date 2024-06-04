package com.example.model;

import jakarta.persistence.Entity;
 @Entity
public class Mecanico extends Persona{

    private String turno;

    private double salario;

    public Mecanico() {

    }

     public Mecanico(String nss, String nombre, String direccion, String turno, double salario) {
         super(nss, nombre, direccion);
         this.turno = turno;
         this.salario = salario;
     }

     public String getTurno() {
         return turno;
     }

     public void setTurno(String turno) {
         this.turno = turno;
     }

     public double getSalario() {
         return salario;
     }

     public void setSalario(double salario) {
         this.salario = salario;
     }

     @Override
     public String toString() {
         return "Mecanico{" +
                 "turno=" + turno +
                 ", salario=" + salario +
                 '}';
     }
 }
