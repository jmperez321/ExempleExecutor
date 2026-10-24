package s2.cosa2;

public class Fil extends Thread{

    public Fil(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("Hola soc el fil %s%n", getName());
    }

    static void main() throws InterruptedException {
        Fil f1 = new Fil("Fil 1");
        Fil f2 = new Fil("Fil 2");
        Fil f3 = new Fil("Fil 3");
        Fil f4 = new Fil("Fil 4");

        f1.start();
        f2.start();
        f3.start();
        f4.start();

        f1.join();
        f2.join();
        f3.join();
        f4.join();
        System.out.println("Acabat!");
    }
}
