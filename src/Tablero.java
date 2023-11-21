import java.util.ArrayList;

public class Tablero {
    //Jugadores y metodos
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private ArrayList<Casilla> tableros = new ArrayList<>();

    public void AgregarJugador(){

    }

    public Jugador ObtenerJugador(int id){

        return null;

    }

    @Override
    public String toString() {
        return "Tablero{" + "listaJugadores=" + listaJugadores + '}';
    }


    //Juego
    public static int lanzarUNDado() {
        // Utilizamos la clase java.util.Random para generar números aleatorios
        java.util.Random random = new java.util.Random();

        // Generamos un número aleatorio entre 1 y 6 (inclusive)
        int resultado = random.nextInt(6) + 1;

        // Devolvemos el resultado
        return resultado;
    }
    public static int lanzarDOSDado() {
        // Utilizamos la clase java.util.Random para generar números aleatorios
        java.util.Random random = new java.util.Random();

        // Generamos un número aleatorio entre 1 y 6 (inclusive)
        int resultado = random.nextInt(12) + 1;

        // Devolvemos el resultado
        return resultado;
    }
}
