package Ejemplo2;

public class Funcion {
    private String pelicula;
    private String horaInicio;
    private Sala sala;
    private double precioEntrada;

    public Funcion(String pelicula, String horaInicio, Sala sala, double precioEntrada) {
        this.pelicula = pelicula;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.precioEntrada = precioEntrada;
    }

    public String obtenerPelicula() {
        return pelicula;
    }

    public String obtenerHoraInicio() {
        return horaInicio;
    }

    public Sala obtenerSala() {
        return sala;
    }

    public double obtenerPrecioEntrada() {
        return precioEntrada;
    }
}
