import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableroOca extends JFrame {

    private JPanel tableroPanel;
    private JButton dadoButton;
    private JButton mostrarJugadoresButton;
    private JLabel turnoLabel;
    private int numeroDados = 1;
    private List<Jugador> jugadores;
    private int turnoActual = 0;
    private boolean turnoDadoLanzado = false;

    public TableroOca() {
        setTitle("Tablero de la Oca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);

        solicitarInfoJugadores();

        tableroPanel = new JPanel();
        tableroPanel.setLayout(new GridLayout(9, 9));

        for (int i = 1; i <= 63; i++) {
            JButton casilla = new JButton(Integer.toString(i));
            casilla.setName("Casilla" + i);
            casilla.setPreferredSize(new Dimension(75, 75));
            casilla.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Verificar si los dados se han lanzado antes de cambiar el turno y procesar la casilla
                    if (turnoDadoLanzado) {
                        procesarCasilla((JButton) e.getSource()); // Pasar el botón como argumento
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero debes lanzar los dados.");
                    }
                }
            });
            tableroPanel.add(casilla);
        }

        dadoButton = new JButton("Lanzar Dado(s)");
        dadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzarDado();
            }
        });

        mostrarJugadoresButton = new JButton("Mostrar Jugadores");
        mostrarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarJugadores();
            }
        });

        turnoLabel = new JLabel("Turno del Jugador: " + jugadores.get(turnoActual).getNombre());

        JPanel dadoPanel = new JPanel();
        dadoPanel.add(new JLabel("Número de dados:"));
        JRadioButton dadoUnico = new JRadioButton("1");
        JRadioButton dosDados = new JRadioButton("2");
        ButtonGroup group = new ButtonGroup();
        group.add(dadoUnico);
        group.add(dosDados);
        dadoUnico.setSelected(true);

        dadoUnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroDados = 1;
            }
        });

        dosDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroDados = 2;
            }
        });

        dadoPanel.add(dadoUnico);
        dadoPanel.add(dosDados);

        add(tableroPanel, BorderLayout.CENTER);
        add(dadoPanel, BorderLayout.SOUTH);
        add(dadoButton, BorderLayout.NORTH);
        add(mostrarJugadoresButton, BorderLayout.EAST);
        add(turnoLabel, BorderLayout.WEST);

        setVisible(true);
    }

    private void solicitarInfoJugadores() {
        jugadores = new ArrayList<>();

        int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (mínimo 2):"));

        while (numJugadores < 2) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 2 jugadores.");
            numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (mínimo 2):"));
        }

        for (int i = 0; i < numJugadores; i++) {
            String nombre = JOptionPane.showInputDialog("Nombre del Jugador " + (i + 1) + ":");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del Jugador " + (i + 1) + ":"));
            String colorFicha = JOptionPane.showInputDialog("Color de la ficha del Jugador " + (i + 1) + ":");

            Jugador jugador = new Jugador(nombre, edad, colorFicha);
            jugadores.add(jugador);
        }
    }

    private void lanzarDado() {
        Random rand = new Random();
        int resultado = 0;
        for (int i = 0; i < numeroDados; i++) {
            resultado += rand.nextInt(6) + 1;
        }
        JOptionPane.showMessageDialog(null, "Resultado del dado(s): " + resultado);

        // Establecer la bandera de turnoDadoLanzado a true
        turnoDadoLanzado = true;
    }

    private void mostrarJugadores() {
        StringBuilder mensaje = new StringBuilder("Lista de Jugadores:\n");
        for (Jugador jugador : jugadores) {
            mensaje.append(jugador.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void procesarCasilla(JButton casilla) {
        // Obtener el nombre del jugador actual y asociarlo con el botón
        String nombreJugador = jugadores.get(turnoActual).getNombre();
        casilla.setText(casilla.getText() + " - " + nombreJugador);

        // Cambiar el turno al siguiente jugador y actualizar el JLabel
        turnoActual = (turnoActual + 1) % jugadores.size();
        actualizarTurnoLabel();

        // Restablecer la bandera de turnoDadoLanzado a false después de procesar la casilla
        turnoDadoLanzado = false;
    }

    private void actualizarTurnoLabel() {
        turnoLabel.setText("Turno del Jugador: " + jugadores.get(turnoActual).getNombre());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TableroOca());
    }
}
