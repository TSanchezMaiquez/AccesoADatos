package com.example.model.manytomanu;

import jakarta.persistence.*;

import java.time.LocalDate;
//IMPORTANTE: Si a la entity le pones nombre le estas indicando que esta tabla se esta generando
//en otra a traves de la relacion ManyToMany, en este caso "users_projects esta en la entity Proyecto
@Entity(name = "users_projects")
public class UserProject {
    /*Una entity debe tener Id siempre, pero para evitar que se generen doblemente ya que aparece aqui
    * y en la entity donde se genera esta tabla aqui se les indica a las Ids que no se inserten*/
    @Id
    @Column(name= "project_id", insertable = false, updatable = false)
    private Long projectId;
    @Id
    @Column(name= "user_id", insertable = false, updatable = false)
    private Long userId;
/*Al declarar esta clase como Entity y enlazarla con la tabla que se esta creando en Proyect a traves
* del nombre podemos incluir nuevas propiedades*/
    private LocalDate initDate;
    private LocalDate endDate;
    @ManyToOne
    private Role role;




    public UserProject() {
    }

    public UserProject(Project project, User user, Role role, LocalDate initDate, LocalDate endDate) {
        this.projectId = project.getId();
        this.userId = user.getId();
        this.role = role;
        this.initDate = initDate;
        this.endDate = endDate;

    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectID) {
        this.projectId = projectID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserProject{" +
                "projectID=" + projectId +
                ", userId=" + userId +
                ", initDate=" + initDate +
                ", endDate=" + endDate +
                '}';
    }
}
