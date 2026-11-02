package concurrencia.radiado;

public class MainRadiado {
    public static void main(String[] args) {
        int capacidadBuffer = 3;
        int numeroConsumidores = 4;

        BufferRadiado buffer = new BufferRadiado(capacidadBuffer, numeroConsumidores);

        System.out.println("--- INICIO DEL RADIADO ATÓMICO ---");
        System.out.println("Capacidad: " + capacidadBuffer + " | Consumidores: " + numeroConsumidores);

        // Lanzamos al productor
        new Productor(buffer).start();

        // Lanzamos a los consumidores con velocidades aleatorias.
        // ¡Alguno será el "amigo lento" que bloqueará al productor!
        for (int i = 0; i < numeroConsumidores; i++) {
            int velocidadAleatoria = (int)(Math.random() * 3000) + 1000;
            new Consumidor(i, buffer, velocidadAleatoria).start();
        }
    }
}