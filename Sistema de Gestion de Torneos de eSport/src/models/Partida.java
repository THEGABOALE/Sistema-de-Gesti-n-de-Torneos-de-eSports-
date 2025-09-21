package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Partida {
    private final Torneo torneo;     // composición
    private final Juego juego;
    private final Equipo equipoA;
    private final Equipo equipoB;
    private final Arbitro arbitro;
    private final LocalDateTime fechaHora;

    Partida(Torneo torneo, Juego juego, Equipo equipoA, Equipo equipoB, Arbitro arbitro, LocalDateTime fechaHora) {
        if (torneo == null || juego == null || equipoA == null || equipoB == null || arbitro == null)
            throw new IllegalArgumentException("Datos de partida incompletos");
        if (Objects.equals(equipoA, equipoB))
            throw new IllegalArgumentException("Los equipos deben ser distintos");
        this.torneo = torneo;
        this.juego = juego;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.arbitro = arbitro;
        this.fechaHora = fechaHora;
    }

    public Torneo getTorneo() { return torneo; }
    public Juego getJuego() { return juego; }
    public Equipo getEquipoA() { return equipoA; }
    public Equipo getEquipoB() { return equipoB; }
    public Arbitro getArbitro() { return arbitro; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return "Partida{" + juego.getNombre() + " | " + equipoA.getNombre() + " vs " + equipoB.getNombre() +
                " @ " + fechaHora + " | árbitro=" + arbitro.getNombre() + "}";
    }
}