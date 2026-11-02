package concurrencia.canibales;

public class MainRio {
    public static void main(String[] args) {
        Bote bote = new Bote();

        System.out.println("--- COMIENZA EL CRUCE DEL RÍO ---");

        // Vamos a generar una mezcla de misioneros y caníbales
        // Por ejemplo, creamos 6 Misioneros y 6 Caníbales desordenados.
        for (int i = 1; i <= 12; i++) {
            if (Math.random() > 0.5) {
                new Misionero("M" + i, bote).start();
            } else {
                new Canibal("C" + i, bote).start();
            }

            // Un pequeño retardo para que no lleguen todos exactamente a la vez
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}