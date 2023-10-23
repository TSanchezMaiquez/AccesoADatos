package datos;

import domain.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";
    private static final String SQL_INSERT = "insert into empleados(nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE ="update empleados set nomEmp=?, sexEmp=?, fecNac=?, fecIncorporacion=?, salEmp=?, comisionE=?, " +
            "cargoE=?, jefeID=?, codDepto=?";


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
                String jefeId = rs.getString("jefeID");
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
                e.printStackTrace(System.out);
            }
        }

        return empleados;
    }

    public int insertar (Empleado empleado){

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros =0;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getIdEmpleado());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getSexoString());
            stmt.setDate(4, empleado.getFechaNac());
            stmt.setDate(5, empleado.getFechaIncorporacion());
            stmt.setFloat(6, empleado.getSalario());
            stmt.setFloat(7, empleado.getComision());
            stmt.setString(8, empleado.getCargo());
            stmt.setString(9, empleado.getJefeId());
            stmt.setString(10, empleado.getCodDepartamento());

            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar (Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros =0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);


            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getSexoString());
            stmt.setDate(3, empleado.getFechaNac());
            stmt.setDate(4, empleado.getFechaIncorporacion());
            stmt.setFloat(5, empleado.getSalario());
            stmt.setFloat(6, empleado.getComision());
            stmt.setString(7, empleado.getCargo());
            stmt.setString(8, empleado.getJefeId());
            stmt.setString(9, empleado.getCodDepartamento());
            stmt.setString(10, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

    return registros;
    }
}
