import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import datos.Conexion;
import datos.EmpleadoDAO;
import domain.Empleado;

public class Main {

    public static void main(String[] args) {

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        List<Empleado> empleados = empleadoDAO.seleccionar();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}