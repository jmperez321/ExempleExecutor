package puntuacioDeJugadors;

public class Jugador implements Comparable<Jugador>{
    private String nom;
    private int puntos;

    public Jugador(String nom) {
        this.nom = nom;
        puntos = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nom='" + nom + '\'' +
                ", puntos=" + puntos +
                '}';
    }

    @Override
    public int compareTo(Jugador o) {
        if (this.puntos < o.getPuntos()){
            return 1;
        } else if (this.puntos>o.getPuntos()) {
            return -1;
        }else{
            return 0;
        }
        // return Integer.compare(o.puntos,this.puntos);
    }
}
