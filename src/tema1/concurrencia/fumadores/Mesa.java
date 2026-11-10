package tema1.concurrencia.fumadores;

public class Mesa {
    private boolean mesaVacia = true;
    // ingredienteFalta indicará para quién son los ingredientes (0, 1 o 2)
    private int ingredienteFalta = -1;

    // Método que usa el Proveedor
    public synchronized void colocarIngredientes(int falta) throws InterruptedException {
        // Si ya hay ingredientes en la mesa, el proveedor espera
        while (!mesaVacia) {
            wait();
        }

        ingredienteFalta = falta;
        mesaVacia = false;

        String faltaTexto = (falta == 0) ? "Papel" : (falta == 1) ? "Tabaco" : "Fósforos";
        System.out.println("Proveedor coloca ingredientes. Falta: " + faltaTexto);

        // Avisa a los fumadores de que hay cosas en la mesa
        notifyAll();
    }

    // Método que usan los Fumadores
    public synchronized void tomarIngredientes(int idFumador) throws InterruptedException {
        // Un fumador espera si la mesa está vacía O si los ingredientes que hay no son para él
        while (mesaVacia || ingredienteFalta != idFumador) {
            wait();
        }

        // ¡Son sus ingredientes! Los coge de la mesa.
        mesaVacia = true;
        ingredienteFalta = -1;

        String tieneTexto = (idFumador == 0) ? "Papel" : (idFumador == 1) ? "Tabaco" : "Fósforos";
        System.out.println("Fumador " + idFumador + " (con " + tieneTexto + ") coge los ingredientes de la mesa.");

        // ¡LA CLAVE DE LA VERSIÓN AVANZADA!
        // Avisa al proveedor de que la mesa vuelve a estar libre ANTES de ponerse a fumar.
        notifyAll();
    }
}