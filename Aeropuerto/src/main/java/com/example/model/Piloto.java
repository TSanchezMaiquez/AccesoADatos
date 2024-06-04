package com.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Piloto extends Persona{

    @Column(name = "n_lic")
    private String numLic;

    @ManyToMany
    @JoinTable(
            name = "pilota",
            joinColumns = @JoinColumn(name = "nss_piloto"),
            inverseJoinColumns = @JoinColumn(name = "tipo_modelo")
    )
    private Set<Tipo> tipos = new HashSet<>();

    public Piloto() {

    }

    public Piloto(String nss, String nombre, String direccion, String numLic) {
        super(nss, nombre, direccion);
        this.numLic = numLic;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Tipo> tipos) {
        this.tipos = tipos;
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
                ", nss=" + getNss() +
                ", numLic=" + numLic +
                '}';
    }
}
