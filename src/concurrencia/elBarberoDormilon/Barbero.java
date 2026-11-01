package concurrencia.elBarberoDormilon;

public class Barbero extends Thread {
    private Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Entra al monitor para ver si hay clientes o dormir
                barberia.esperarCliente();

                // Fuera del monitor: simulamos el tiempo que tarda en cortar el pelo
                // Es crucial que esto NO esté dentro de un método 'synchronized'
                Thread.sleep(2000);

                // Entra al monitor para avisar que ha terminado
                barberia.terminarCorte();
            } catch (InterruptedException e) {
                System.out.println("El barbero cierra por hoy.");
                break;
            }
        }
    }
}