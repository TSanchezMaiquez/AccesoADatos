package domain;

public class Departamento {

private String codDepto;
private String nombreDpto;
private String ciudad;
private String codDirector;

public Departamento(){

}
public Departamento(String codDepto){
    this.codDepto= codDepto;
}

    public Departamento(String codDepto, String nombreDpto, String ciudad, String codDirector) {
        this.codDepto = codDepto;
        this.nombreDpto = nombreDpto;
        this.ciudad = ciudad;
        this.codDirector = codDirector;
    }

    public Departamento(String nombreDpto, String ciudad, String codDirector) {
        this.nombreDpto = nombreDpto;
        this.ciudad = ciudad;
        this.codDirector = codDirector;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodDirector() {
        return codDirector;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codDepto='" + codDepto + '\'' +
                ", nombreDpto='" + nombreDpto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codDirector='" + codDirector + '\'' +
                '}';
    }
}
