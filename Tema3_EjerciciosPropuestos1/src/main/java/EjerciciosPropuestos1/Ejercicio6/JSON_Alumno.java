package EjerciciosPropuestos1.Ejercicio6;

import java.sql.*;

import static org.hibernate.sql.ast.Clause.FROM;

public class JSON_Alumno {
    private final String url = "jdbc:mysql://localhost:3306/alumnos";
    private final String user = "root";
    private final String password = "1234";

    public void mostrarJSON() throws SQLException {

        String sql = "SELECT nombre, JSON_EXTRACT(info, '$.curso') AS curso FROM alumno";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");

                System.out.println(nombre + " - " + curso);
            }
        }
    }
}



