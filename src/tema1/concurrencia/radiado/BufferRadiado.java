package tema1.concurrencia.radiado;

public class BufferRadiado {
    private int[] buffer;
    private int capacidad;
    private int numConsumidores;

    private int producidos = 0; // Total histórico de elementos producidos
    private int[] leidos;       // leidos[i] indica cuántos elementos en total ha leído el consumidor i

    public BufferRadiado(int capacidad, int numConsumidores) {
        this.capacidad = capacidad;
        this.numConsumidores = numConsumidores;
        this.buffer = new int[capacidad];
        this.leidos = new int[numConsumidores]; // En Java, los arrays de int se inicializan solos a 0
    }

    // Método auxiliar para buscar al "amigo más lento"
    private int obtenerMinimoLeidos() {
        int min = leidos[0];
        for (int i = 1; i < numConsumidores; i++) {
            if (leidos[i] < min) {
                min = leidos[i];
            }
        }
        return min;
    }

    public synchronized void producir(int elemento) throws InterruptedException {
        // El productor espera si la diferencia entre lo que ha producido
        // y lo que ha leído el más lento es igual a la capacidad del buffer.
        // Es decir: el más lento no ha liberado espacio aún.
        while (producidos - obtenerMinimoLeidos() == capacidad) {
            wait();
        }

        // Lo inserta en la posición circular
        buffer[producidos % capacidad] = elemento;
        producidos++;
        System.out.println("Productor inserta el elemento: " + elemento);

        // Avisa a los consumidores que hay un nuevo elemento
        notifyAll();
    }

    public synchronized int consumir(int idConsumidor) throws InterruptedException {
        // Un consumidor espera si ya ha leído todos los elementos producidos hasta ahora
        while (leidos[idConsumidor] == producidos) {
            wait();
        }

        // Lee el elemento de la posición circular
        int elemento = buffer[leidos[idConsumidor] % capacidad];
        leidos[idConsumidor]++; // Suma 1 a su contador personal de leídos

        System.out.println("Consumidor " + idConsumidor + " lee el elemento: " + elemento);

        // Avisamos al productor porque, si yo era el consumidor "más lento",
        // al avanzar acabo de liberar un hueco en el buffer.
        notifyAll();

        return elemento;
    }
}