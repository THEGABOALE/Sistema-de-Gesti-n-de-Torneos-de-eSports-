package models;

import java.util.Objects;

public final class Categoria {
    private final String nombre;

    public Categoria(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de categoría requerido");
            this.nombre = nombre.trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Categoría{" + "nombre=" + nombre + '}';
    }

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
