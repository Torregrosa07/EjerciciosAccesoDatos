package Ejercicio4;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        AlumnoDAO dao = new AlumnoDAO();

        dao.insertar("Lionel", 38);
        dao.insertar("Pepe", 22);

        List<String> lista = dao.listar();
        System.out.println("Alumnos: ");
        for (String alumno : lista) {
            System.out.println(alumno);
        }
    }
}
