package EjerciciosPropuestos1.Ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoFileRepository {
    private final File file = new File("alumnos.txt");

    public void guardar(List<String> alumnos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String alumno : alumnos) {
                writer.write(alumno);
                writer.newLine();
            }
        }
    }

    public List<String> cargar() throws IOException {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        }
        return lista;
    }


    public static void main(String[] args) throws IOException {
        AlumnoFileRepository repo = new AlumnoFileRepository();
        repo.guardar(List.of("Santiago,18", "David,21", "Alejandro,19"));
        System.out.println("Datos leídos: " + repo.cargar());
    }
}
