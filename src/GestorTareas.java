import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;
    private GestorArchivos gestorArchivos;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.gestorArchivos = new GestorArchivos("tareas.txt");
        cargarTareas();
    }

    private void cargarTareas() {
        tareas = gestorArchivos.leerTareas();
    }

    public void agregarTarea(String descripcion, Date fecha, String hora) {
        Tarea tarea = new Tarea(descripcion, fecha, hora);
        tareas.add(tarea);
        gestorArchivos.escribirTareas(tareas);
    }

    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.completarTarea();
            gestorArchivos.escribirTareas(tareas);
        } else {
            System.out.println("Índice de tarea no válido");
        }
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
            gestorArchivos.escribirTareas(tareas);
        } else {
            System.out.println("Índice de tarea no válido");
        }
    }

    public void eliminarTareasCompletadas() {
        List<Tarea> tareasAEliminar = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.estaCompletada()) {
                tareasAEliminar.add(tarea);
            }
        }
        tareas.removeAll(tareasAEliminar);
        gestorArchivos.escribirTareas(tareas);
    }

    public void generarReporte() {
        int completadas = 0;
        int enProgreso = 0;

        for (Tarea tarea : tareas) {
            if (tarea.estaCompletada()) {
                completadas++;
            } else {
                enProgreso++;
            }
        }

        System.out.println("Tareas completadas: " + completadas);
        System.out.println("Tareas en progreso: " + enProgreso);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}
