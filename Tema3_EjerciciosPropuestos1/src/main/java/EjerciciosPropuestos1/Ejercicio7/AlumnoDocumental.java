package EjerciciosPropuestos1.Ejercicio7;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AlumnoDocumental {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String file = "alumnos.json";

    public void guardar(List<Map<String, Object>> alumnos) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(alumnos, fw);
        }

    }

    public List<Map<String, Object>> leer() throws IOException {
        try (FileReader fr = new FileReader(file)) {
            return gson.fromJson(fr, List.class);
        }
    }

    public static void main(String[] args) throws IOException {
        AlumnoDocumental alumnoDoc = new AlumnoDocumental();
        List<Map<String, Object>> lista = List.of(
                Map.of("nombre", "Carlos", "edad", 20, "curso", "2DAM")
        );
        alumnoDoc.guardar(lista);
        System.out.println(alumnoDoc.leer());
    }
}
