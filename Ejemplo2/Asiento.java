package Ejemplo2;


public class Asiento {
    private int numero;
    private String estado;

    public Asiento(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int obtenerNumero() {
        return numero;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void reservar() {
        this.estado = "reservado";
    }
}
