package Ejemplo4;
import javax.swing.*;
import java.util.ArrayList;

public class Agregar extends ProductoPerecedero {
    private static ArrayList<Agregar> listaProducctos = new ArrayList<>();
    private static int contadorProductos = 0;

    public Agregar(String nombre, String descripcion, double precio, int stock) {
        super(nombre, descripcion, precio, stock);
    }

    public static ArrayList<Agregar> obtenerlistaProducctos() {
        return listaProducctos;
    }

    public static void agregarProduccto(Agregar producto) {
        listaProducctos.add(producto);
        contadorProductos++;
    }

    public static Agregar crearProduccto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");

        double precio = 0.0;
        int stock = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un valor numérico válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        entradaValida = false;
        while (!entradaValida) {
            try {
                stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un valor numérico válido para el stock.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        Agregar nuevoProducto = new Agregar(nombre, descripcion, precio, stock);
        agregarProduccto(nuevoProducto);
        return nuevoProducto;
    }

    public static void mostrarProducctos() {
        StringBuilder sb = new StringBuilder("Productos disponibles: \n");
        for (Agregar producto : listaProducctos) {
            sb.append("Producto ").append(listaProducctos.indexOf(producto) + 1)
                    .append(": ").append("\n").append("Nombre del producto: ").append(producto.obtenerNombre()).append("\n")
                    .append("Descripción: ").append(producto.obtenerDescripcion()).append("\n")
                    .append("Precio: ").append(producto.obtenerPrecio()).append("\n")
                    .append("Stock en inventario: ").append(producto.obtenerStock()).append("\n")
                    .append("Fecha de vencimiento: ").append(producto.mostrarFecha()).append("\n").append("--------------------").append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de productos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void eliminarProduccto(String nombre) {
        boolean encontrado = false;
        for (Agregar producto : listaProducctos) {
            if (producto.obtenerNombre().equalsIgnoreCase(nombre)) {
                listaProducctos.remove(producto);
                JOptionPane.showMessageDialog(null, "Producto eliminado: " + nombre, "Eliminar Producto", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Eliminar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void modificarStock(String nombre, int nuevoStock) {
        boolean encontrado = false;
        for (Agregar producto : listaProducctos) {
            if (producto.obtenerNombre().equalsIgnoreCase(nombre)) {
                producto.cambiarStock(nuevoStock);
                JOptionPane.showMessageDialog(null, "Stock modificado para: " + nombre, "Modificar Stock", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Modificar Stock", JOptionPane.ERROR_MESSAGE);
        }
    }
}