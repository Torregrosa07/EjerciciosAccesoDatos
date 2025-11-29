import EjerciciosPropuestos1.Ejercicio4.AlumnoDAO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoDAOTest {
    @Test
    public void insertarAlumno() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        assertDoesNotThrow(() -> alumnoDAO.insertar("Sebastian", 20));
    }

}
