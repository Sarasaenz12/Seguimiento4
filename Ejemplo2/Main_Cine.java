package Ejemplo2;

import javax.swing.*;

public class Main_Cine {

    public static void main(String[] args) {
        Sala sala = new Sala(1);
        Funcion funcion = new Funcion("Inception", "20:00", sala, 10.0);

        Cliente cliente = crearCliente();

        while (true) {
            sala.mostrarAsientos();

            if (sala.todosAsientosOcupados()) {
                JOptionPane.showMessageDialog(null, "Todos los asientos están ocupados. No se pueden realizar más reservas.");
                break;
            }

            int numeroAsiento = obtenerNumeroAsiento(sala);

            if (numeroAsiento == -1) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, intente nuevamente.");
                continue;
            }

            Asiento asiento = sala.obtenerAsiento(numeroAsiento);

            if (asiento.obtenerEstado().equals("disponible")) {
                sala.reservarAsiento(numeroAsiento);
                Reserva reserva = new Reserva(cliente, funcion);
                reserva.agregarAsiento(asiento);
                cliente.agregarReserva(reserva);

                JOptionPane.showMessageDialog(null, "Reserva completada.\n" +
                        "Película: " + funcion.obtenerPelicula() + "\n" +
                        "Hora: " + funcion.obtenerHoraInicio() + "\n" +
                        "Asiento: " + asiento.obtenerNumero() + "\n" +
                        "Precio: $" + funcion.obtenerPrecioEntrada());

                int continuar = JOptionPane.showConfirmDialog(null, "¿Desea hacer una nueva reserva?", "Nueva Reserva", JOptionPane.YES_NO_OPTION);

                if (continuar != JOptionPane.YES_OPTION) {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El asiento ya está reservado. Por favor, elija otro.");
            }
        }

        mostrarHistorialReservas(cliente);
    }

    private static Cliente crearCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String identificacion = JOptionPane.showInputDialog("Ingrese su identificación:");
        String direccion = JOptionPane.showInputDialog("Ingrese su dirección:");
        return new Cliente(nombre, identificacion, direccion);
    }

    private static int obtenerNumeroAsiento(Sala sala) {
        try {
            int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del asiento que desea reservar (1-20):"));
            if (numeroAsiento < 1 || numeroAsiento > sala.obtenerCapacidad()) {
                return -1; // Entrada inválida
            }
            return numeroAsiento;
        } catch (NumberFormatException e) {
            return -1; // Entrada no es un número válido
        }
    }

    private static void mostrarHistorialReservas(Cliente cliente) {
        StringBuilder historial = new StringBuilder("Historial de reservas:\n");
        for (Reserva r : cliente.obtenerHistorialReservas()) {
            historial.append("Película: ").append(r.obtenerFuncion().obtenerPelicula()).append(", ")
                    .append("Hora: ").append(r.obtenerFuncion().obtenerHoraInicio()).append(", ")
                    .append("Asiento(s): ");
            for (Asiento a : r.obtenerListaAsientos()) {
                historial.append(a.obtenerNumero()).append(" ");
            }
            historial.append("\n");
        }
    }



}

