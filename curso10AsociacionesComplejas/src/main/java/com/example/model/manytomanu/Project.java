package com.example.model.manytomanu;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String prefix;
    @ManyToMany
    @JoinTable(
            //Crea una nueva tabla llamada users_projects
            name = "users_projects",
            //Coge la id de esta entity y
            joinColumns = @JoinColumn(name = "project_id"),
            //la id de la entity User, sabe que es de esta tabla porque la propiedad es de User:
            // "private Set<User> users = new HashSet<>();"
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public Project() {
    }

    public Project(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
