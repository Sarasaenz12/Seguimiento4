package Ejemplo6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Biblioteca:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Buscar libro por autor");
            System.out.println("5. Listar todos los libros");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca, scanner);
                    break;
                case 2:
                    eliminarLibro(biblioteca, scanner);
                    break;
                case 3:
                    buscarLibroPorTitulo(biblioteca, scanner);
                    break;
                case 4:
                    buscarLibroPorAutor(biblioteca, scanner);
                    break;
                case 5:
                    biblioteca.listarLibros();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        String ISBN = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Libro libro = new Libro(titulo, autor, ISBN, anioPublicacion);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado correctamente.");
    }

    private static void eliminarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String ISBN = scanner.nextLine();
        biblioteca.eliminarLibro(ISBN);
        System.out.println("Libro eliminado correctamente.");
    }

    private static void buscarLibroPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();
        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

    private static void buscarLibroPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el autor del libro a buscar: ");
        String autor = scanner.nextLine();
        Libro libro = biblioteca.buscarLibroPorAutor(autor);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("No se encontró un libro de ese autor.");
        }
    }
    }

