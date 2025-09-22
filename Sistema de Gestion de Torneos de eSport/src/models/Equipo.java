package models;
import java.util.Objects;
import java.util.*;

public class Equipo {
    private final String nombre;
    private final List<Jugador> jugadores = new ArrayList<>();
    private final Set<Torneo> torneos = new HashSet<>();

    public Equipo(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre de equipo requerido");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    public List<Jugador> getJugadores() {
        return Collections.unmodifiableList(jugadores);
    }

    public Set<Torneo> getTorneos() {
        return Collections.unmodifiableSet(torneos);
    }

    public boolean agregarJugador(Jugador j) {
        if (j == null) throw new IllegalArgumentException("Jugador nulo");
        if (jugadores.contains(j)) return false;
        return jugadores.add(j);
    }

    public boolean removerJugador(Jugador j) {
        if (j == null) return false;
        return jugadores.remove(j);
    }

    void _linkTorneo(Torneo t) { if (t != null) torneos.add(t); }
    void _unlinkTorneo(Torneo t) { if (t != null) torneos.remove(t); }

    @Override
    public String toString() {
        return "Equipo{nombre='" + nombre + "', jugadores=" + jugadores.size() + ", torneos=" + torneos.size() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return nombre.equalsIgnoreCase(equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
}