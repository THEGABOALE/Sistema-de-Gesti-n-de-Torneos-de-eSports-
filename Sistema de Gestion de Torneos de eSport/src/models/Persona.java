package models;

public abstract class Persona {
    private final String nombre;

    protected Persona(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{nombre='" + nombre + "'}";
    }

}
