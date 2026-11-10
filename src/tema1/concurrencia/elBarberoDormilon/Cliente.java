package tema1.concurrencia.elBarberoDormilon;

public class Cliente extends Thread {
    private int idCliente;
    private Barberia barberia;

    public Cliente(int idCliente, Barberia barberia) {
        this.idCliente = idCliente;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        try {
            boolean haEntrado = barberia.entrarYPedirCorte(idCliente);
            if (haEntrado) {
                // El cliente logró ser atendido. Su hilo termina exitosamente.
                System.out.println("Cliente " + idCliente + " sale feliz con su nuevo corte.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}