package concurrencia.radiado;

public class Productor extends Thread {
    private BufferRadiado buffer;

    public Productor(BufferRadiado buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int dato = 1;
        while (true) {
            try {
                buffer.producir(dato);
                dato++;
                // El productor genera datos muy rápido (cada medio segundo)
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}