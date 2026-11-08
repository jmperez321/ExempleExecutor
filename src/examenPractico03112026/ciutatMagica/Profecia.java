package examenPractico03112026.ciutatMagica;

public class Profecia extends Thread{
    private Clau c;

    public Profecia(Clau c, Guardia g) {
        this.c = c;
    }

    @Override
    public void run() {
        while (!c.isPotPasar()) {
            c.comprovarProfecia();
        }
    }
}
