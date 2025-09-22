package models;

import java.util.Objects;

public final class Categoria {
    private final String nombre;

    public Categoria(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre de categoría requerido");
        }
        nombre = nombre.trim();          // normaliza primero
        if (nombre.isEmpty()) {          // valida vacío después de trim
            throw new IllegalArgumentException("Nombre de categoría requerido");
        }
        this.nombre = nombre;            // SIEMPRE se alcanza
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() { return "Categoría{nombre=" + nombre + "}"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria that = (Categoria) o;
        return nombre.equalsIgnoreCase(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
}