import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeerJSON {
    public static void main(String[] args) {
        String archivo = "example.json";

        try {
            // Leer el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));

            // Convertir el contenido en un JSONObject
            JSONObject jsonObject = new JSONObject(contenido);

            // Obtener el objeto "quiz"
            JSONObject quiz = jsonObject.getJSONObject("quiz");

            // Acceder a la categoría "sport"
            JSONObject sport = quiz.getJSONObject("sport").getJSONObject("q1");
            System.out.println("Categoría: Sport");
            System.out.println("Pregunta: " + sport.getString("question"));
            System.out.println("Opciones:");
            JSONArray opcionesSport = sport.getJSONArray("options");
            for (int i = 0; i < opcionesSport.length(); i++) {
                System.out.println("- " + opcionesSport.getString(i));
            }
            System.out.println("Respuesta correcta: " + sport.getString("answer"));
            System.out.println();

            // Acceder a la categoría "maths"
            JSONObject maths = quiz.getJSONObject("maths");
            System.out.println("Categoría: Maths");
            for (String key : maths.keySet()) {
                JSONObject pregunta = maths.getJSONObject(key);
                System.out.println("Pregunta: " + pregunta.getString("question"));
                System.out.println("Opciones:");
                JSONArray opcionesMath = pregunta.getJSONArray("options");
                for (int i = 0; i < opcionesMath.length(); i++) {
                    System.out.println("- " + opcionesMath.getString(i));
                }
                System.out.println("Respuesta correcta: " + pregunta.getString("answer"));
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error procesando JSON: " + e.getMessage());
        }
    }
}
