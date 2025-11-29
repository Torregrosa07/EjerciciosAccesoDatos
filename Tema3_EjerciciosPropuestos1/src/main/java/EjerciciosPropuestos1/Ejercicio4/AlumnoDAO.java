package EjerciciosPropuestos1.Ejercicio4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private final String url = "jdbc:mysql://localhost:3306/alumnos";
    private final String user = "root";
    private final String password = "1234";


    public void insertar(String nombre, int edad) throws SQLException {
        String sql = "INSERT INTO alumno(nombre,edad) VALUES (?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, edad);
            stmt.executeUpdate();
        }
    }

    public List<String> listar() throws SQLException {
        List<String> alumnos = new ArrayList<>();
        String sql = "SELECT nombre FROM alumno";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                alumnos.add(rs.getString("nombre"));
            }
        }
        return alumnos;
    }

}

