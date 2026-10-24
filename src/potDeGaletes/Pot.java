package potDeGaletes;

public class Pot {
    private boolean lliure;
    private int galetes;

    public Pot() {
        lliure = true;
        galetes = 0;
    }

    public synchronized void agafaGaleta() {
        while (!lliure || galetes == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        galetes--;
        lliure = false;
        notifyAll();
    }


    public synchronized void posarGaletes() {

        try {
            while (!lliure || galetes > 0) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        galetes += 10;
        lliure = false;
        notifyAll();
    }

    public synchronized void deixarPot() {
        lliure = true;
        notifyAll();
    }
}