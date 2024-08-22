package Ejemplo2;
import javax.swing.*;

public class Sala {
    private int numero;
    private int capacidad;
    private Asiento[] listaAsientos;

    public Sala(int numero) {
        this.numero = numero;
        this.capacidad = 20;
        this.listaAsientos = new Asiento[capacidad];
        for (int i = 0; i < capacidad; i++) {
            listaAsientos[i] = new Asiento(i + 1, "disponible");
        }
    }

    public int obtenerNumero() {
        return numero;
    }

    public int obtenerCapacidad() {
        return capacidad;
    }

    public Asiento obtenerAsiento(int numero) {
        return listaAsientos[numero - 1];
    }

    public void mostrarAsientos() {
        StringBuilder sb = new StringBuilder("Asientos disponibles:\n");
        for (Asiento asiento : listaAsientos) {
            sb.append("Asiento ").append(asiento.obtenerNumero())
                    .append(": ").append(asiento.obtenerEstado()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Asientos", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean todosAsientosOcupados() {
        for (Asiento asiento : listaAsientos) {
            if (asiento.obtenerEstado().equals("disponible")) {
                return false;
            }
        }
        return true;
    }

    public void reservarAsiento(int numero) {
        listaAsientos[numero - 1].reservar();
    }
}

