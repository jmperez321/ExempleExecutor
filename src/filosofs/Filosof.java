package filosofs;

public class Filosof extends Thread {
    Cobert esquerra;
    Cobert dreta;

    public Filosof(String nom, Cobert esquerra, Cobert dreta) {
        super(nom);
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    @Override
    public void run() {
        for (; ; ) {
            esquerra.agafar();
            dreta.agafar();
            System.out.println(getName() + " Manjat...");
            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            esquerra.deixar();
            dreta.deixar();
            System.out.println(getName() + " Pensant...");

            try {
                Thread.sleep((long) (Math.random() * 200) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
