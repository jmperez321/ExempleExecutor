package concurrencia.fumadores;

public class Proveedor extends Thread {
    private Mesa mesa;

    public Proveedor(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Genera un número aleatorio entre 0 y 2
                int ingredienteQueFalta = (int) (Math.random() * 3);
                mesa.colocarIngredientes(ingredienteQueFalta);

                // Pequeña pausa para que la consola sea legible
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}