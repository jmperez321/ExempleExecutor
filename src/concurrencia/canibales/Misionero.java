package concurrencia.canibales;

public class Misionero extends Thread {
    private String nombre;
    private Bote bote;

    public Misionero(String nombre, Bote bote) {
        this.nombre = nombre;
        this.bote = bote;
    }

    @Override
    public void run() {
        try {
            bote.llegaMisionero(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}