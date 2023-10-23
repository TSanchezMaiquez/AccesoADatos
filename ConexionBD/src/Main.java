import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import datos.Conexion;
import datos.EmpleadoDAO;
import domain.Empleado;

public class Main {

    public static void main(String[] args) {

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        Empleado empleadoNuevo = new Empleado ("11.000.11", "pepe sanchez",'v', new Date(20001010), new Date(20221228), 20000,
                2000, "Pringao", "11.111.111", "4000");


        //empleadoDAO.insertar(empleadoNuevo);

        Empleado empleadoModificar = new Empleado ("11.000.111","Jose Sanchez", 'v', Date.valueOf("2000-10-10"), Date.valueOf("2022-10-10"), 20000,
                2000, "Pringao", "11.111.111", "4000");

        empleadoDAO.actualizar(empleadoModificar);
        List<Empleado> empleados = empleadoDAO.seleccionar();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }


    }
}