package concurrencia.canibales;

public class Canibal extends Thread {
    private String nombre;
    private Bote bote;

    public Canibal(String nombre, Bote bote) {
        this.nombre = nombre;
        this.bote = bote;
    }

    @Override
    public void run() {
        try {
            bote.llegaCanibal(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}