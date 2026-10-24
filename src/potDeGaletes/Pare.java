package potDeGaletes;

public class Pare extends Thread {
    private Pot pg;

    public Pare(String nom, Pot pg) {
        super(nom);
        this.pg=pg;
    }

    @Override
    public void run() {
        for(;;){
            pg.posarGaletes();
            System.out.println("El pot ya es ple");
            pg.deixarPot();
            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
