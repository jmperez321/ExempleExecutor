package puntuacioDeJugadors;

public class DarPuntos implements Runnable {

    Jugador jg;

    public DarPuntos(Jugador jg) {
        this.jg = jg;
    }

    @Override
    public void run() {

        int puntos = (int) (Math.random() * 10 + 1);
        System.out.println(jg.getNom() + ": +" + puntos + " punts.");
        jg.addPuntos(puntos);

    }
}
