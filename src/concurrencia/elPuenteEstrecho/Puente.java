package concurrencia.elPuenteEstrecho;

public class Puente {
    int sentidoTrafico = 0; // 0=vacío, 1=izquierda, 2=derecha
    int maxCoches = 3;
    int coches = 0;

    public Puente() {
    }

    public synchronized void llegarAlPuente(int sentidoCoche) throws InterruptedException {
        while ((coches > 0 && sentidoCoche != sentidoTrafico) || coches == maxCoches) {
            wait();
        }
        coches++;
        this.sentidoTrafico=sentidoCoche;

    }

    public synchronized void salirDelPuente(int setidoCoche){
        coches--;
        if (coches==0) sentidoTrafico=0;
        notifyAll();
    }


}
