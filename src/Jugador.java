public class Jugador {
    private String nombre;
    private int Puntaje;
    private int edad;
    private String colorFicha;

    public Jugador(String nombre, int edad, String colorFicha) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorFicha = colorFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public String getcolorFicha() {
        return colorFicha;
    }

    public void setcolorFicha(int colorFicha) {
        this.Puntaje = colorFicha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", colorFicha='" + colorFicha + '\'' +
                '}';
    }
}
