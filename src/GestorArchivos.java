import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    String descripcion = partes[0];
                    Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(partes[1]);
                    String hora = partes[2];
                    tareas.add(new Tarea(descripcion, fecha, hora));
                } else {
                    // Manejar el formato incorrecto del archivo
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return tareas;
    }

    public void escribirTareas(List<Tarea> tareas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Tarea tarea : tareas) {
                String linea = tarea.getDescripcion() + "," +
                        new SimpleDateFormat("yyyy-MM-dd").format(tarea.getFecha()) + "," +
                        tarea.getHora();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
