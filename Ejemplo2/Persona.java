package Ejemplo2;

public class Persona {
    private String nombre;
    private String identificacion;
    private String direccion;

    public Persona(String nombre, String identificacion, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    public String obtenerDireccion() {
        return direccion;
    }
}
