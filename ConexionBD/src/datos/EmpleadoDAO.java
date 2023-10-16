package datos;

import domain.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";

    public List<Empleado> seleccionar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String idEmpleado = rs.getString("nDIEmp");
                String nomEmp = rs.getString("nomEmp");
                String sexEmp = rs.getString("sexEmp");
                Date fecNac = rs.getDate("fecNac");
                Date fecIncorporacion = rs.getDate("fecIncorporacion");
                float salEmp = rs.getFloat("salEmp");
                float comisionE = rs.getFloat("comisionE");
                String cargoE = rs.getString("cargoE");
                String jefeId =rs.getString("jefeID");
                String departamento = rs.getString("codDepto");

                empleado = new Empleado(idEmpleado, nomEmp, sexEmp.charAt(0), fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeId, departamento);
                empleados.add(empleado);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return empleados;
    }


}
