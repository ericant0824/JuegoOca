public class Jugador {
    private String nombre;
    private int Puntaje;
    private int cedula;
    private String colorFicha;

    public Jugador(String nombre, int Puntaje, int cedula) {
        this.nombre = nombre;
        this.Puntaje = Puntaje;
        this.cedula = cedula;
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", Puntaje=" + Puntaje + ", cedula=" + cedula + '}';
    }
}
