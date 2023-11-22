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
    private int numeroDados = 1; // Por defecto, inicia con un dado
    private List<Jugador> jugadores; // Lista para almacenar los jugadores

    public TableroOca() {
        // Configuración del marco
        setTitle("Tablero de la Oca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        // Configuración del panel del tablero
        tableroPanel = new JPanel();
        tableroPanel.setLayout(new GridLayout(8, 8));

        // Crear casillas del tablero
        for (int i = 1; i <= 64; i++) {
            JButton casilla = new JButton(Integer.toString(i));
            casilla.setPreferredSize(new Dimension(75, 75));
            casilla.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí puedes manejar la lógica cuando se hace clic en una casilla
                    JOptionPane.showMessageDialog(null, "Haz clic en la casilla: " + casilla.getText());
                }
            });
            tableroPanel.add(casilla);
        }

        // Botón para lanzar el dado
        dadoButton = new JButton("Dado");
        dadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzarDado();
            }
        });

        // Botón para mostrar la lista de jugadores
        mostrarJugadoresButton = new JButton("Mostrar Jugadores");
        mostrarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarJugadores();
            }
        });

        // Panel para los botones dado y mostrar jugadores
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(dadoButton);
        buttonsPanel.add(mostrarJugadoresButton);

        // Agregar componentes al marco
        add(tableroPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Hacer visible el marco
        setVisible(true);

        // Inicializar la lista de jugadores
        jugadores = new ArrayList<>();
    }

    private void lanzarDado() {
        Random rand = new Random();
        int resultado = 0;
        for (int i = 0; i < numeroDados; i++) {
            resultado += rand.nextInt(6) + 1; // Generar números aleatorios del 1 al 6
        }
        JOptionPane.showMessageDialog(null, "Resultado del dado: " + resultado);
    }

    private void mostrarJugadores() {
        StringBuilder jugadoresInfo = new StringBuilder("Lista de Jugadores:\n");
        for (Jugador jugador : jugadores) {
            jugadoresInfo.append(jugador.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, jugadoresInfo.toString());
    }

    public static void main(String[] args) {

        int cantidadJugadores;

        // Solicitar la cantidad de jugadores hasta que sea al menos 2
        do {
            cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores (mínimo 2):"));
            if (cantidadJugadores < 2) {
                JOptionPane.showMessageDialog(null, "Debe haber al menos 2 jugadores. Inténtelo nuevamente.");
            }
        } while (cantidadJugadores < 2);

        // Crear una lista para almacenar los jugadores
        List<Jugador> jugadores = new ArrayList<>();

        // Solicitar los datos para cada jugador
        for (int i = 1; i <= cantidadJugadores; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + i + ":");

            // Solicitar la edad y asegurarse de que esté entre 8 y 99 años
            int edad;
            do {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del jugador " + i + ":"));
                if (edad < 8 || edad > 99) {
                    JOptionPane.showMessageDialog(null, "La edad debe estar entre 8 y 99 años. Inténtelo nuevamente.");
                }
            } while (edad < 8 || edad > 99);

            String colorFicha = JOptionPane.showInputDialog("Ingrese el color de ficha del jugador " + i + ":");

            // Crear un nuevo jugador y agregarlo a la lista
            Jugador jugador = new Jugador(nombre, edad, colorFicha);
            jugadores.add(jugador);
        }

        // Imprimir la información de los jugadores
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableroOca();
            }
        });
    }

}




