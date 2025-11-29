package EjerciciosPropuestos1.Ejercicio10;

import EjerciciosPropuestos1.Ejercicio4.AlumnoDAO;

import java.io.IOException;
import java.sql.SQLException;

public class AlumnoService {
    private final AlumnoDAO alumnoDAO = new AlumnoDAO();

    public void agregarAlumno(String nombre, int edad) throws IOException, SQLException {
        alumnoDAO.insertar(nombre, edad);
    }

    public void mostrarAlumnos() throws Exception{
        alumnoDAO.listar().forEach(System.out::println);
    }
}
