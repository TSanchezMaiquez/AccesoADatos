package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.NaturalId;

@Entity
public class Piloto extends Persona{



    @NaturalId
    @Column(nullable = false, unique = true, name = "n_lic")
    private String numLic;

    public Piloto() {

    }

    public Piloto(String nss, String nombre, String direccion, String numLic) {
        super(nss, nombre, direccion);
        this.numLic = numLic;
    }


    public String getNumLic() {
        return numLic;
    }

    public void setNumLic(String numLic) {
        this.numLic = numLic;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                ", numLic=" + numLic +
                '}';
    }
}
