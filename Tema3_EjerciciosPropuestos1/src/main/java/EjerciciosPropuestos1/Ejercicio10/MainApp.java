package EjerciciosPropuestos1.Ejercicio10;

public class MainApp {
    public static void main(String[] args) throws Exception {
        AlumnoService service = new AlumnoService();

        service.agregarAlumno("Jesus", 22);
        service.mostrarAlumnos();
    }
}
