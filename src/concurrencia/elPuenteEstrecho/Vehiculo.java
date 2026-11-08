package concurrencia.elPuenteEstrecho;

public class Vehiculo extends Thread {
    private String name = "";
    private int sentidoCoche = 0; // 0=vacío, 1=izquierda, 2=derecha
    private Puente p;

    public Vehiculo(String name, int sentidoCoche, Puente p) {
        this.name = name;
        this.sentidoCoche = sentidoCoche;
        this.p = p;
    }


    @Override
    public void run() {
        try {
            p.llegarAlPuente(sentidoCoche);
            System.out.println("Coche " + name + " [Sentido " + sentidoCoche + "] ENTRA al puente.");
            Thread.sleep((long) (Math.random() * 2000) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Coche " + name + " [Sentido " + sentidoCoche + "] SALE del puente.");
        p.salirDelPuente(sentidoCoche);
    }
}
