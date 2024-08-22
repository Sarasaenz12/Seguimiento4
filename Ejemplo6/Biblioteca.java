package Ejemplo6;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String ISBN) {
        libros.removeIf(libro -> libro.getISBN().equals(ISBN));
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public Libro buscarLibroPorAutor(String autor) {
        return libros.stream()
                .filter(libro -> libro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            libros.forEach(System.out::println);
        }
    }
}
