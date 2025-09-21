package models;

import java.time.LocalDateTime;
import java.util.*;

public class Torneo {
    private final String nombre;
    // N:M con Equipo
    private final Set<Equipo> equipos = new HashSet<>();
    // Composición: Partida pertenece al Torneo
    private final List<Partida> partidas = new ArrayList<>();

    public Torneo(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre de torneo requerido");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }
    public Set<Equipo> getEquipos() { return Collections.unmodifiableSet(equipos); }
    public List<Partida> getPartidas() { return Collections.unmodifiableList(partidas); }

    public boolean agregarEquipo(Equipo e) {
        if (e == null) throw new IllegalArgumentException("Equipo nulo");
        boolean added = equipos.add(e);
        if (added) e._linkTorneo(this);
        return added;
    }

    public boolean removerEquipo(Equipo e) {
        if (e == null) return false;
        boolean removed = equipos.remove(e);
        if (removed) e._unlinkTorneo(this);
        return removed;
    }

    public Partida programarPartida(Juego juego, Equipo a, Equipo b, Arbitro arbitro, LocalDateTime fechaHora) {
        if (juego == null || a == null || b == null || arbitro == null)
            throw new IllegalArgumentException("Referencias requeridas");
        if (a.equals(b)) throw new IllegalArgumentException("Los equipos deben ser distintos");
        if (!equipos.contains(a) || !equipos.contains(b))
            throw new IllegalStateException("Ambos equipos deben estar inscritos en el torneo");
        Partida p = new Partida(this, juego, a, b, arbitro, fechaHora != null ? fechaHora : LocalDateTime.now());
        partidas.add(p);
        return p;
    }

    public void eliminar() {
        partidas.clear();
        for (Equipo e : new ArrayList<>(equipos)) e._unlinkTorneo(this);
        equipos.clear();
    }

    @Override
    public String toString() {
        return "Torneo{nombre='" + nombre + "', equipos=" + equipos.size() + ", partidas=" + partidas.size() + "}";
    }
}
