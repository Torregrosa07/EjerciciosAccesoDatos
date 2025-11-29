package EjerciciosPropuestos2.Ejercicio2;

import java.sql.*;

public class AlumnoDAOPlus {
    private final String url = "jdbc:mysql://localhost:3306/alumnos";
    private final String user = "root";
    private final String pass = "1234";

    public void actualizarEdad(String nombre, int nuevaEdad) throws SQLException {
        String sql = "UPDATE alumno SET edad = ? WHERE nombre = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, nuevaEdad);
            st.setString(2, nombre);
            st.executeUpdate();
        }
    }

    public String buscarPorNombre(String nombre) throws SQLException {
        String sql = "SELECT nombre FROM alumno WHERE nombre = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, nombre);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre");
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        AlumnoDAOPlus dao = new AlumnoDAOPlus();
        dao.actualizarEdad("Juan", 22);

        String resultado = dao.buscarPorNombre("Juan");
        System.out.println("Alumno encontrado: " + resultado);
    }

}
