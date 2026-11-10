package tema1.concurrencia.radiado;

public class Consumidor extends Thread {
    private int id;
    private BufferRadiado buffer;
    private int velocidadLenta; // Simularemos que unos tardan más que otros

    public Consumidor(int id, BufferRadiado buffer, int velocidadLenta) {
        this.id = id;
        this.buffer = buffer;
        this.velocidadLenta = velocidadLenta;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consumir(id);
                // Simulamos que el consumidor procesa el dato a su propio ritmo
                Thread.sleep(velocidadLenta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}