package concurrencia.canibales;

public class Bote {
    // Contadores de gente esperando en la orilla
    private int misionerosOrilla = 0;
    private int canibalesOrilla = 0;

    // "Tickets" para dejar cruzar a los que están dormidos en el wait()
    private int misionerosAprobados = 0;
    private int canibalesAprobados = 0;

    public synchronized void llegaMisionero(String nombre) throws InterruptedException {
        misionerosOrilla++; // Me pongo a esperar en la orilla

        if (misionerosOrilla >= 3) {
            // ¡Combinación Válida: 3 Misioneros!
            misionerosOrilla -= 3;
            misionerosAprobados += 2; // Yo cruzo directo, así que emito tickets para 2 misioneros más
            System.out.println("\n>>> BOTE LLENO: " + nombre + " organiza un viaje de 3 Misioneros.");
            notifyAll();

        } else if (misionerosOrilla >= 1 && canibalesOrilla >= 2) {
            // ¡Combinación Válida: 1 Misionero y 2 Caníbales!
            misionerosOrilla -= 1;
            canibalesOrilla -= 2;
            canibalesAprobados += 2; // Yo soy el misionero, emito tickets para 2 caníbales
            System.out.println("\n>>> BOTE LLENO: " + nombre + " organiza un viaje de 1 Misionero y 2 Caníbales.");
            notifyAll();

        } else {
            // No formo grupo. Me toca dormir hasta que alguien emita un ticket para misionero.
            while (misionerosAprobados == 0) {
                wait();
            }
            misionerosAprobados--; // Consumo mi ticket
        }

        System.out.println(nombre + " (Misionero) cruza el río.");
    }

    public synchronized void llegaCanibal(String nombre) throws InterruptedException {
        canibalesOrilla++; // Me pongo a esperar en la orilla

        if (canibalesOrilla >= 3) {
            // ¡Combinación Válida: 3 Caníbales!
            canibalesOrilla -= 3;
            canibalesAprobados += 2; // Yo cruzo directo, emito tickets para 2 caníbales más
            System.out.println("\n>>> BOTE LLENO: " + nombre + " organiza un viaje de 3 Caníbales.");
            notifyAll();

        } else if (canibalesOrilla >= 2 && misionerosOrilla >= 1) {
            // ¡Combinación Válida: 1 Misionero y 2 Caníbales!
            canibalesOrilla -= 2;
            misionerosOrilla -= 1;
            canibalesAprobados += 1; // Yo soy el primer caníbal. Emito ticket para el otro caníbal...
            misionerosAprobados += 1; // ... y ticket para el misionero.
            System.out.println("\n>>> BOTE LLENO: " + nombre + " organiza un viaje de 1 Misionero y 2 Caníbales.");
            notifyAll();

        } else {
            // No formo grupo. Me toca dormir hasta que alguien emita un ticket para caníbal.
            while (canibalesAprobados == 0) {
                wait();
            }
            canibalesAprobados--; // Consumo mi ticket
        }

        System.out.println(nombre + " (Caníbal) cruza el río.");
    }
}