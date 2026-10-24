package potDeGaletes;

public class Fill extends Thread {
    private Pot pg;

    public Fill(String nom, Pot pg) {
        super(nom);
        this.pg=pg;
    }

    @Override
    public void run() {
        for(;;){
            pg.agafaGaleta();
            System.out.println("Menjant Galetes");
            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Deixa el pot, ja no hi te gana");
            pg.deixarPot();
            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Torna a tenir gana");
        }
    }
}
