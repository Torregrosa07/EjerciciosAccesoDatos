package EjerciciosPropuestos2.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlumnoJsonRepository {
    private final String fichero = "alumnos.json";
    private final Gson gson = new Gson();


    public void guardar(List<Map<String, Object>> alumnos) throws IOException {
        try (FileWriter writer = new FileWriter(fichero)) {
            gson.toJson(alumnos, writer);
        }
    }

    public List<Map<String, Object>> cargar() throws IOException {
        try (FileReader reader = new FileReader(fichero)) {
            return gson.fromJson(reader, List.class);
        }
    }

    public static void main(String[] args) throws IOException {
        AlumnoJsonRepository repo = new AlumnoJsonRepository();

        List<Map<String, Object>> misAlumnos = List.of(
                Map.of("nombre", "Paco", "edad", 25)
        );

        repo.guardar(misAlumnos);
        System.out.println("Leído del archivo: " + repo.cargar());
    }
}
