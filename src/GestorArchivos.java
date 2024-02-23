import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    private String nombreArchivo;

    public GestorArchivos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<Tarea> leerTareas() {
        List<Tarea> tareas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                tareas.add(new Tarea(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tareas;
    }

    public void escribirTareas(List<Tarea> tareas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Tarea tarea : tareas) {
                bw.write(tarea.getDescripcion());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

