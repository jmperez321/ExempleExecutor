package tema1.concurrencia.fumadores;

public class Fumador extends Thread {
    private int id; // 0 = Tiene papel, 1 = Tiene tabaco, 2 = Tiene fósforos
    private Mesa mesa;

    public Fumador(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Intenta coger los ingredientes. Si no son los suyos, se queda bloqueado.
                mesa.tomarIngredientes(id);

                // ¡ZONA FUERA DEL MONITOR!
                // Como el método tomarIngredientes ya terminó, el monitor Mesa está desbloqueado.
                // El proveedor ya está poniendo nuevos ingredientes mientras nosotros fumamos aquí abajo.
                System.out.println("   -> Fumador " + id + " está fumando... 🚬");
                Thread.sleep(2000); // Tarda 2 segundos en fumarse el cigarrillo
                System.out.println("   -> Fumador " + id + " terminó de fumar.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}