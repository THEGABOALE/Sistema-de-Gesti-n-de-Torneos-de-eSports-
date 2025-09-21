package models;

public class Jugador extends Persona {
    private final String alias;
    private int ranking;

    public Jugador(String nombre, String alias, int ranking) {
        super(nombre);
        if (alias == null || alias.isBlank())
            throw new IllegalArgumentException("Alias requerido");
        this.alias = alias.trim();
        this.ranking = ranking;
    }

    public String getAlias() { return alias; }
    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    @Override public String toString() {
        return "Jugador{alias='" + alias + "', nombre='" + getNombre() + "', ranking=" + ranking + "}";
    }
}