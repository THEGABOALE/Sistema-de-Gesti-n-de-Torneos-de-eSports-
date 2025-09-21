package models;

public final class Juego {
    private final String nombre;
    private final Categoria categoria;

    public Juego(String nombre, Categoria categoria) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de juego requerido");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoría requerida");
        }
        this.nombre = nombre.trim();
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juego)) return false;
        Juego juego = (Juego) o;
        return nombre.equalsIgnoreCase(juego.nombre) && categoria.equals(juego.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), categoria);
    }
}
