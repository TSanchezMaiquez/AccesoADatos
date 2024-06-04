package com.example.model.onetomany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cif;

    //@OneToMany(mappedBy = "company")
    /*Esta relacion solo se puede mapear desde la entity Company ya que en la entity Employee
    * no se ha hecho la relacion ManyToOne*/
    @OneToMany
    @JoinTable(name = "companies_employees",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    Set<Employee> employees = new HashSet<>();


    public Company() {
    }

    public Company(String cif) {
        this.cif = cif;
    }

    public Company(String cif, Set<Employee> employees) {
        this.cif = cif;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                '}';
    }
}
