package tallerCostura;

public class Cistell {
    private int maxCap;
    private int cantidad;
    private String tipus;

    public Cistell(int maxCap) {
        this.maxCap = maxCap;
        this.cantidad = 0;
    }

    public synchronized void afegir() throws InterruptedException {
        while (cantidad == maxCap) {
            wait();
        }
        cantidad++;
        notifyAll();

    }

    public synchronized void treure(int n) throws InterruptedException {
        while (cantidad < n) {
            wait();
        }
        cantidad -= n;
        notifyAll();
    }


}
