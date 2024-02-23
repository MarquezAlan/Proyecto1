import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private GestorTareas gestorTareas;

    private JTextField txtDescripcion;
    private DefaultListModel<String> listModel;
    private JList<String> listaTareas;

    public InterfazGrafica() {
        super("Aplicación de Lista de Tareas");
        gestorTareas = new GestorTareas();

        // Configuración del frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel para agregar tarea
        JPanel panelAgregar = new JPanel(new FlowLayout());
        txtDescripcion = new JTextField(20);
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = txtDescripcion.getText();
                gestorTareas.agregarTarea(descripcion);
                cargarTareas();
                txtDescripcion.setText("");
            }
        });
        panelAgregar.add(txtDescripcion);
        panelAgregar.add(btnAgregar);

        // Lista de tareas
        listModel = new DefaultListModel<>();
        listaTareas = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaTareas);

        // Panel para botones de acción
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnCompletar = new JButton("Completar tarea");
        btnCompletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaTareas.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    gestorTareas.completarTarea(indiceSeleccionado);
                    cargarTareas();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una tarea para completar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton btnEliminar = new JButton("Eliminar tarea");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaTareas.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    gestorTareas.eliminarTarea(indiceSeleccionado);
                    cargarTareas();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una tarea para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton btnReporte = new JButton("Generar reporte");
        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorTareas.generarReporte();
            }
        });
        panelBotones.add(btnCompletar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnReporte);

        // Agregar componentes al panel principal
        panel.add(panelAgregar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Agregar panel al frame
        add(panel);

        // Cargar tareas al iniciar la aplicación
        cargarTareas();
    }

    private void cargarTareas() {
        listModel.clear();
        List<Tarea> tareas = gestorTareas.getTareas();
        for (Tarea tarea : tareas) {
            String estado = tarea.estaCompletada() ? "[Completada] " : "[En progreso] ";
            listModel.addElement(estado + tarea.getDescripcion());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }
}
