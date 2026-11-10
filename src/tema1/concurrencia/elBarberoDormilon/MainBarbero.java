package tema1.concurrencia.elBarberoDormilon;


public class MainBarbero {
    public static void main(String[] args) {
        // Configuramos la sala de espera con N sillas (ej.: 3)
        Barberia barberia = new Barberia(3);

        // Creamos y arrancamos al barbero
        Barbero barbero = new Barbero(barberia);
        barbero.start();
        int i = 1;
        // Simulamos la llegada de 10 clientes a lo largo del tiempo
        for (;;) {
            i++;
            Cliente cliente = new Cliente(i, barberia);
            cliente.start();

            try {
                // Si llegan muy rápido, la sala se llenará y algunos se marcharán.
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}