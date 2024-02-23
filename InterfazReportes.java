import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazReportes extends JFrame {
    private GestorTareas gestorTareas;
    private JTextArea txtAreaReporteCompleto;

    public InterfazReportes(GestorTareas gestorTareas) {
        super("Reportes de Tareas");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\tarea.png"));
        this.gestorTareas = gestorTareas;

        // Configuración del frame
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Panel para mostrar el reporte completo
        JPanel panelReporteCompleto = new JPanel();
        panelReporteCompleto.setLayout(null);
        txtAreaReporteCompleto = new JTextArea(10, 50);
        txtAreaReporteCompleto.setEditable(false);
        JScrollPane scrollPaneReporteCompleto = new JScrollPane(txtAreaReporteCompleto);
        scrollPaneReporteCompleto.setBounds(0, 0, 586, 363);
        panelReporteCompleto.add(scrollPaneReporteCompleto);

        // Agregar componentes al panel principal
        panel.add(panelReporteCompleto, BorderLayout.CENTER);

        // Agregar panel al frame
        getContentPane().add(panel);

        // Generar el reporte completo
        generarReporteCompleto();
    }

    private void generarReporteCompleto() {
        StringBuilder reporte = new StringBuilder();
        List<Tarea> tareas = gestorTareas.getTareas();
        int completadas = 0;
        int noCompletadas = 0;
        for (Tarea tarea : tareas) {
            if (tarea.estaCompletada()) {
                completadas++;
            } else {
                noCompletadas++;
            }
        }
        reporte.append("Número total de tareas completadas: ").append(completadas).append("\n");
        reporte.append("Tareas completadas:\n");
        for (Tarea tarea : tareas) {
            if (tarea.estaCompletada()) {
                reporte.append("- ").append(tarea.getDescripcion()).append("\n");
            }
        }
        reporte.append("\nNúmero total de tareas no completadas: ").append(noCompletadas).append("\n");
        reporte.append("Tareas no completadas:\n");
        for (Tarea tarea : tareas) {
            if (!tarea.estaCompletada()) {
                reporte.append("- ").append(tarea.getDescripcion()).append("\n");
            }
        }
        txtAreaReporteCompleto.setText(reporte.toString());
    }
}
