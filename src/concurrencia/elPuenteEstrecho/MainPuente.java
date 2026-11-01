package concurrencia.elPuenteEstrecho;

public class MainPuente {
    public static void main(String[] args) {

        Puente puente = new Puente();

        String[] marcas = {"Toyota", "Seat", "Hyundai", "BMW", "Fiat", "Ford", "Audi", "Renault", "Opel", "Kia"};

        System.out.println("--- EMPIEZA LA SIMULACIÓN DEL TRÁFICO ---");

        // 2. Creamos y lanzamos 10 coches
        for (int i = 0; i < 10; i++) {
            int sentidoAleatorio = (int) (Math.random() * 2) + 1;

            Vehiculo v = new Vehiculo(marcas[i], sentidoAleatorio, puente);

            v.start();

        }
    }

}
