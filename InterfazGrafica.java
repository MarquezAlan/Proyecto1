import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private GestorTareas gestorTareas;

    private JTextField txtDescripcion;
    private JTextField txtFecha;
    private JTextField txtHora;
    private DefaultListModel<String> listModel;
    private JList<String> listaTareas;

    public InterfazGrafica() {
        super("Aplicación de Lista de Tareas");
        gestorTareas = new GestorTareas();

        // Configuración del frame
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título dentro del programa
        JLabel titulo = new JLabel("Gestor de Tareas");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        // Panel para agregar tarea
        JPanel panelAgregar = new JPanel(new GridLayout(5, 2)); // Ahora es 5 filas
        JLabel lblTituloDescripcion = new JLabel("Gestor de Tareas"); // Nuevo JLabel para el título
        lblTituloDescripcion.setFont(new Font("Arial", Font.BOLD, 16)); // Formato del título
        lblTituloDescripcion.setHorizontalAlignment(JLabel.CENTER); // Centrado
        JLabel lblDescripcion = new JLabel("Descripción:");
        txtDescripcion = new JTextField(20);
        JLabel lblFecha = new JLabel("Fecha (yyyy-MM-dd):");
        txtFecha = new JTextField(10);
        JLabel lblHora = new JLabel("Hora (HH:mm):");
        txtHora = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = txtDescripcion.getText();
                String fechaStr = txtFecha.getText();
                String hora = txtHora.getText();
                Date fecha = null;
                try {
                    fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                gestorTareas.agregarTarea(descripcion, fecha, hora);
                cargarTareas();
                txtDescripcion.setText("");
                txtFecha.setText("");
                txtHora.setText("");
            }
        });
        panelAgregar.add(lblTituloDescripcion); // Agregar el nuevo JLabel
        panelAgregar.add(new JLabel()); // Espacio en blanco para ocupar el lugar del campo de texto
        panelAgregar.add(lblDescripcion);
        panelAgregar.add(txtDescripcion);
        panelAgregar.add(lblFecha);
        panelAgregar.add(txtFecha);
        panelAgregar.add(lblHora);
        panelAgregar.add(txtHora);
        panelAgregar.add(btnAgregar);

        // Lista de tareas
        listModel = new DefaultListModel<>();
        listaTareas = new JList<>(listModel);
        listaTareas.setBackground(new Color(255, 128, 64));
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
        JButton btnEliminarCompletadas = new JButton("Eliminar tareas completadas");
        btnEliminarCompletadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTareasCompletadas();
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
                // Crear e iniciar la ventana de reportes
                InterfazReportes interfazReportes = new InterfazReportes(gestorTareas);
                interfazReportes.setVisible(true);
            }
        });
        panelBotones.add(btnCompletar);
        panelBotones.add(btnEliminarCompletadas);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnReporte);

        // Agregar componentes al panel principal
        panel.add(panelAgregar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Agregar panel al frame
        getContentPane().add(panel);

        // Cargar tareas al iniciar la aplicación
        cargarTareas();
    }

    private void cargarTareas() {
        listModel.clear();
        List<Tarea> tareas = gestorTareas.getTareas();
        for (Tarea tarea : tareas) {
            String estado = tarea.estaCompletada() ? "[Completada] " : "[En progreso] ";
            String descripcion = tarea.getDescripcion();
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(tarea.getFecha());
            String hora = tarea.getHora();
            listModel.addElement(estado + descripcion + " - Hora: " + hora + " - Fecha: " + fecha);
        }
    }

    private void eliminarTareasCompletadas() {
        gestorTareas.eliminarTareasCompletadas();
        cargarTareas();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }
}
