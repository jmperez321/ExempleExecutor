package concurrencia.elBarberoDormilon;

public class Barberia {
    private int sillasLibres;
    private boolean barberoOcupado = false;

    public Barberia(int sillasTotales) {
        this.sillasLibres = sillasTotales;
    }

    // Métod que ejecutan los hilos Client
    public synchronized boolean entrarYPedirCorte(int idCliente) throws InterruptedException {
        // Regla 2: Si tot está ocupado, el cliente se marcha.
        if (sillasLibres == 0 && barberoOcupado) {
            System.out.println("Cliente " + idCliente + " entra. Todo lleno. Se marcha de la barbería.");
            return false;
        }

        // Regla 3: Si el barbero está ocupado, pero, hay sillas, se sienta a esperar.
        if (barberoOcupado) {
            sillasLibres--;
            System.out.println("Cliente " + idCliente + " se sienta a esperar. Sillas libres: " + sillasLibres);

            while (barberoOcupado) {
                wait(); // Queda esperando hasta que el barbero termine el corte anterior
            }

            sillasLibres++; // Se levanta de la silla de espera
        }

        // Regla 4: Si el barbero está dormido, lo despierta (y ocupa la silla).
        barberoOcupado = true;
        System.out.println("Cliente " + idCliente + " se sienta en la silla del barbero.");
        notifyAll(); // Avisa al barbero de que tiene cliente
        return true;
    }
    // Métod que ejecuta el hilo Barbero
    public synchronized void esperarCliente() throws InterruptedException {
        // Regla 1: Si no hay clientes, el barbero se echa a dormir.
        while (!barberoOcupado) {
            System.out.println("Barbero: Zzzzz... (Dormido porque no hay clientes)");
            wait(); // Duerme hasta que un cliente haga notifyAll()
        }
        System.out.println("Barbero: ¡Despierto! Empiezo a cortar el pelo.");
    }

    // Métod que ejecuta el hilo Barbero al finalizar
    public synchronized void terminarCorte() {
        barberoOcupado = false;
        System.out.println("Barbero: Corte terminado. ¡Siguiente!");
        notifyAll(); // Avisa a los clientes que estén esperando en las sillas
    }
}


