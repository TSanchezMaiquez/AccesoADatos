package datos;
import domain.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    private static final String SQL_SELECT ="select codDepto, nombreDpto, ciudad, codDirector from departamentos";

    public List<Departamento> seleccionar (){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()){
                String codDepartamento = rs.getString("codDepto");
                String nombreDepartamento = rs.getString("nombreDpto");
                String ciudad = rs.getString("ciudad");
                String codigoDirector = rs.getString("codDirector");

                departamento = new Departamento(codDepartamento, nombreDepartamento, ciudad, codigoDirector);
                departamentos.add(departamento);
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
        return departamentos;
    }



}

