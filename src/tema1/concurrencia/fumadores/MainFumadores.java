package tema1.concurrencia.fumadores;

public class MainFumadores {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        Proveedor proveedor = new Proveedor(mesa);

        // Creamos a los 3 fumadores con sus respectivos ingredientes infinitos
        Fumador fumadorConPapel = new Fumador(0, mesa);
        Fumador fumadorConTabaco = new Fumador(1, mesa);
        Fumador fumadorConFosforos = new Fumador(2, mesa);

        System.out.println("--- EMPIEZA LA FUMADA ---");

        proveedor.start();
        fumadorConPapel.start();
        fumadorConTabaco.start();
        fumadorConFosforos.start();
    }
}