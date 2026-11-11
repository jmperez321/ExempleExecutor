package tema2.udp;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) {
        DatagramSocketClient client = new DatagramSocketClient();
        String host = "localhost";
        int port = 5555;

        try {
            System.out.println("Iniciando cliente UDP...");
            client.init(host, port);
            client.runClient();
            System.out.println("Cliente desconectado correctamente.");
        } catch (IOException e) {
            System.err.println("Error en la ejecución del cliente: " + e.getMessage());
        }
    }
}
