package EjerciciosPropuestos2.Ejercicio3;

import java.sql.*;

public class AlumnoJson {
    private final String url = "jdbc:mysql://localhost:3306/alumnos";
    private final String user = "root";
    private final String pass = "1234";

    public void actualizarDatosJson(String nombre, String clave, String valor) throws SQLException {
        String path = "$." + clave;
        String sql = "UPDATE alumno SET info = JSON_SET(info, ?, ?) WHERE nombre = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, path);
            stmt.setString(2, valor);
            stmt.setString(3, nombre);
            stmt.executeUpdate();
        }
    }

    public String leerValorJson(String nombre, String clave) throws SQLException {
        String path = "$." + clave;
        String sql = "SELECT JSON_EXTRACT(info, ?) AS valor FROM alumno WHERE nombre = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, path);
            stmt.setString(2, nombre);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("valor");
                }
            }
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        AlumnoJson manager = new AlumnoJson();

        manager.actualizarDatosJson("Juan", "turno", "tarde");

        String resultado = manager.leerValorJson("Juan", "turno");
        System.out.println("Dato JSON recuperado: " + resultado);
    }

}
