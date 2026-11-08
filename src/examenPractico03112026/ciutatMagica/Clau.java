package examenPractico03112026.ciutatMagica;

public class Clau {
    private int profecia = (int) (Math.random() * 20);
    private boolean potPasar = false;

    public boolean isPotPasar() {
        return potPasar;
    }

    public Clau() {
    }

    public synchronized void comprovarProfecia() {
        while (!potPasar) {
            int prof = (int) (Math.random() * 20);

            if ((this.profecia - 2) <= prof) {
                potPasar = true;
                System.out.println("Clau Correcta");
                notifyAll();
            } else {
                System.out.println("Clau incorrecta");
                notifyAll();
            }
        }

    }

    public synchronized void obrir() {
        while(!potPasar) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("S'ha obrit la torre");
        notifyAll();
    }
}
