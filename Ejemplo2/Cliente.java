package Ejemplo2;

import java.util.ArrayList;

public class Cliente extends Persona {
    private ArrayList<Reserva> historialReservas;

    public Cliente(String nombre, String identificacion, String direccion) {
        super(nombre, identificacion, direccion);
        this.historialReservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    public ArrayList<Reserva> obtenerHistorialReservas() {
        return historialReservas;
    }
}

