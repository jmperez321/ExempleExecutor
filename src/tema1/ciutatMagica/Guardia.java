package tema1.ciutatMagica;

public class Guardia extends Thread {

    private Clau c;

    public Guardia(Clau c) {
        this.c = c;
    }

    @Override
    public void run() {
            c.obrir();
    }
}
