package tallerCostura;

public class Encadellador extends Thread {
    private Cistell manigues;
    private Cistell cossos;
    private int jerseis = 0;

    public Encadellador(Cistell manigues, Cistell cossos) {
        this.manigues = manigues;
        this.cossos = cossos;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                manigues.treure(2);
                cossos.treure(1);
                jerseis++;
                System.out.println("*** +1 Jersey portem: " + jerseis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
