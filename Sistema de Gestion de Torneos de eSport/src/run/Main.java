package run;

import models.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // 1) Catálogo base
        Categoria moba = new Categoria("MOBA");
        Categoria fps = new Categoria("FPS");

        Juego lol = new Juego("League of Legends", moba);
        Juego cs = new Juego("CS:GO", fps);

        // 2) Personas
        Jugador p1 = new Jugador("Carlos Pérez", "Carlitox", 2200);
        Jugador p2 = new Jugador("Ana López", "Anix", 2100);
        Jugador p3 = new Jugador("Luis Gómez", "Luigi", 2050);
        Jugador p4 = new Jugador("María Ruiz", "Marii", 2150);

        Arbitro arbitro = new Arbitro("Sofía Morales");

        // 3) Equipos (agregación: jugadores siguen existiendo si eliminas el equipo)
        Equipo jaguars = new Equipo("Jaguars");
        jaguars.agregarJugador(p1);
        jaguars.agregarJugador(p2);

        Equipo falcons = new Equipo("Falcons");
        falcons.agregarJugador(p3);
        falcons.agregarJugador(p4);

        // 4) Torneo (N:M con equipos, y composición con partidas)
        Torneo copa = new Torneo("Copa Centro eSports");
        copa.agregarEquipo(jaguars);
        copa.agregarEquipo(falcons);

        // 5) Programar partidas (valida: equipos inscritos, A != B)
        copa.programarPartida(lol, jaguars, falcons, arbitro, LocalDateTime.now().plusDays(1));
        copa.programarPartida(cs, falcons, jaguars, arbitro, LocalDateTime.now().plusDays(2));

        // 6) Mostrar estado
        System.out.println(copa);
        for (Partida p : copa.getPartidas()) {
            System.out.println(p);
        }

        // 7) Demostración de composición: eliminar torneo -> desaparecen sus partidas
        System.out.println("\nEliminando torneo...");
        copa.eliminar();
        System.out.println(copa); // partidas=0, equipos=0 (se desenlazan), jugadores siguen existiendo

        // 8) Verificamos que los jugadores siguen (agregación)
        System.out.println("Equipo aún existe: " + jaguars);
        System.out.println("Jugador aún existe: " + p1);
    }