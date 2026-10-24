package filosofs;

public class Cobert {
    //este sera el monitor.
    boolean cobert;

    public Cobert() {
        this.cobert = true;
    }

    public synchronized void agafar() {
        try {
            while (!cobert) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cobert = false;
        notifyAll();
    }

    public synchronized void deixar() {
        cobert = true;
        notifyAll();
    }
}
