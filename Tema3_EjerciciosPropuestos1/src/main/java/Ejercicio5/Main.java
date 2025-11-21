package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        AlumnoRepository repo = new AlumnoRepository();
        repo.insertar(new Alumno("Santiago", 18));
        repo.listar().forEach(a -> System.out.println(a.getNombre()));
    }
}
