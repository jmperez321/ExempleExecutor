package puntuacioDeJugadors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TablaDePuntos {
    static void main() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        List<DarPuntos> lista = new ArrayList<>();

        int maxJg = 3;
        for (int i = 0; i < maxJg; i++) {
            Jugador jg = new Jugador("Melon_" + (i + 1));
            DarPuntos puntos = new DarPuntos(jg);
            lista.add(puntos);
        }
        for (int i = 0; i < maxJg; i++) {
            executor.scheduleWithFixedDelay(lista.get(i), 1, ((int) (Math.random() * 10) + 1), TimeUnit.SECONDS);
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

        int win = 1;
        for (int i = 0; i < maxJg; i++) {
            System.out.println(lista.get(i).jg.getNom()+ " ha aconseguit: " + lista.get(i).jg.getPuntos() + " punts.");
            if (lista.get(i).jg.getPuntos() > lista.get(win).jg.getPuntos()) {
                win = i;
            }
        }
        System.out.println(lista.get(win).jg.getNom() + " ha guanyat amb: " + lista.get(win).jg.getPuntos() + " punts.");
    

    }

}
