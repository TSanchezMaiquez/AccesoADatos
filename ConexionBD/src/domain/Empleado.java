package domain;

import java.util.Date;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private char sexo;
    private Date fechaNac;
    private Date fechaIncorporacion;
    private float salario;
    private float comision;
    private String cargo;
    private String jefeId;
    private String codDepartamento;

    public Empleado() {

    }

    public Empleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, char sexo, Date fechaNac, Date fechaIncorporacion, float salario, float comision, String cargo, String jefeId, String codDepartamento) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.fechaIncorporacion = fechaIncorporacion;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.jefeId = jefeId;
        this.codDepartamento = codDepartamento;
    }

    public Empleado(String idEmpleado, String nombre, char sexo, Date fechaNac, Date fechaIncorporacion, float salario, float comision, String cargo, String jefeId, String codDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.fechaIncorporacion = fechaIncorporacion;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.jefeId = jefeId;
        this.codDepartamento = codDepartamento;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setJefeId(String jefeId) {
        this.jefeId = jefeId;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public float getSalario() {
        return salario;
    }

    public float getComision() {
        return comision;
    }

    public String getCargo() {
        return cargo;
    }

    public String getJefeId() {
        return jefeId;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", fechaNac=" + fechaNac +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", salario=" + salario +
                ", comision=" + comision +
                ", cargo='" + cargo + '\'' +
                ", jefeId='" + jefeId + '\'' +
                ", codDepartamento='" + codDepartamento + '\'' +
                '}';
    }
}
