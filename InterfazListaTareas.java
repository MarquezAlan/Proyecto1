import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfazListaTareas extends JFrame implements ActionListener {
    private ArrayList<String> listaTareas;
    private JTextArea areaTareas;

    public InterfazListaTareas() {
        listaTareas = new ArrayList<>();

        setTitle("Lista de Tareas");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnAgregar = new JButton("Añadir tarea");
        JButton btnMostrar = new JButton("Mostrar lista de tareas");
        JButton btnSalir = new JButton("Salir");

        btnAgregar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSalir.addActionListener(this);

        areaTareas = new JTextArea(10, 20);
        areaTareas.setEditable(false);

        panel.add(btnAgregar);
        panel.add(btnMostrar);
        panel.add(btnSalir);
        panel.add(new JScrollPane(areaTareas));

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Añadir tarea":
                String tarea = JOptionPane.showInputDialog(this, "Ingrese la nueva tarea:");
                if (tarea != null && !tarea.isEmpty()) {
                    listaTareas.add(tarea);
                }
                break;
            case "Mostrar lista de tareas":
                mostrarTareas();
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

    private void mostrarTareas() {
        StringBuilder sb = new StringBuilder();
        for (String tarea : listaTareas) {
            sb.append("- ").append(tarea).append("\n");
        }
        areaTareas.setText(sb.toString());
    }

    public static void main(String[] args) {
        InterfazListaTareas ventana = new InterfazListaTareas();
        ventana.setVisible(true);
    }
}