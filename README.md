Una organización quiere desarrollar un sistema para gestionar torneos de videojuegos (eSports). Este sistema se encargará de manejar equipos, jugadores, juegos, torneos y partidas.
## Requisitos del sistema:
- Un torneo está compuesto por varias partidas (matches). Si el torneo se elimina, sus partidas también.
- Cada partida se juega entre dos equipos y está asociada a un juego (por ejemplo, LoL, CS:GO, etc.).
- Un equipo está compuesto por varios jugadores. Si el equipo se elimina, los jugadores no se eliminan (pueden ser asignados a otro equipo).
- Cada jugador tiene un nombre, alias y ranking.
- Cada juego tiene una categoría (FPS, MOBA, etc.). Las categorías existen por separado del juego.
- Un árbitro supervisa cada partida. Un árbitro puede supervisar muchas partidas, pero una partida tiene un solo árbitro.
- Un equipo puede participar en varios torneos, y un torneo puede tener varios equipos.
## Instrucciones de la Actividad:
- Investiga los tipos de relaciones en diagramas de clases UML:
  - Asociación
  - Composición
  - Agregación
  - Herencia
  - Multiplicidad / cardinalidad (1:1, 1:N, N:M).
  - Analiza el caso de estudio del Sistema de Gestión de Torneos de eSports.
  - Elabora un diagrama de clases UML donde representes las entidades (Torneo, Partida, Equipo, Jugador, Juego, Categoría, Árbitro), sus atributos y relaciones.
- Defiende tu propuesta en la siguiente sesión, explicando las relaciones y
mostrando cómo se representarían en Java mediante clases, atributos y
referencias.

# Diagrama

```mermaid
classDiagram
    direction TB
    
    Persona <|-- Arbitro
    Persona <|-- Jugador
    
    Juego o-- Categoria
    Equipo o-- Jugador
    Torneo *-- Partida
    Partida o-- Juego
    Partida o-- Equipo : equipoA
    Partida o-- Equipo : equipoB
    Partida o-- Arbitro
    Equipo "many" -- "many" Torneo

    class Persona {
        -String nombre
        +Persona(String nombre)
        +getNombre() String
        +toString() String
    }
    
    class Arbitro {
        +Arbitro(String nombre)
    }
    
    class Jugador {
        -String alias
        -int ranking
        +Jugador(String nombre, String alias, int ranking)
        +getAlias() String
        +getRanking() int
        +setRanking(int ranking) void
        +toString() String
    }
    
    class Categoria {
        -String nombre
        +Categoria(String nombre)
        +getNombre() String
        +toString() String
        +equals(Object o) boolean
        +hashCode() int
    }
    
    class Juego {
        -String nombre
        -Categoria categoria
        +Juego(String nombre, Categoria categoria)
        +getNombre() String
        +getCategoria() Categoria
        +equals(Object o) boolean
        +hashCode() int
    }
    
    class Equipo {
        -String nombre
        -List~Jugador~ jugadores
        -Set~Torneo~ torneos
        +Equipo(String nombre)
        +getNombre() String
        +getJugadores() List~Jugador~
        +getTorneos() Set~Torneo~
        +agregarJugador(Jugador j) boolean
        +removerJugador(Jugador j) boolean
        _linkTorneo(Torneo t) void
        _unlinkTorneo(Torneo t) void
        +toString() String
        +equals(Object o) boolean
        +hashCode() int
    }
    
    class Torneo {
        -String nombre
        -Set~Equipo~ equipos
        -List~Partida~ partidas
        +Torneo(String nombre)
        +getNombre() String
        +getEquipos() Set~Equipo~
        +getPartidas() List~Partida~
        +agregarEquipo(Equipo e) boolean
        +removerEquipo(Equipo e) boolean
        +programarPartida(Juego juego, Equipo a, Equipo b, Arbitro arbitro, LocalDateTime fechaHora) Partida
        +eliminar() void
        +toString() String
    }
    
    class Partida {
        -Torneo torneo
        -Juego juego
        -Equipo equipoA
        -Equipo equipoB
        -Arbitro arbitro
        -LocalDateTime fechaHora
        +getTorneo() Torneo
        +getJuego() Juego
        +getEquipoA() Equipo
        +getEquipoB() Equipo
        +getArbitro() Arbitro
        +getFechaHora() LocalDateTime
        +toString() String
    }
```
