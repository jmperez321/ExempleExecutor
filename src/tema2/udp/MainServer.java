package tema2.udp;

import java.io.IOException;

public class MainServer {
    static void main(String[] args) {
        DatagramSocketServer server = new DatagramSocketServer();
        int port = 5555;

        try {
            System.out.println("Servidor UDP iniciado. Esperando conexiones en el puerto " + port + "...");
            server.init(port);
            server.runServer();
        } catch (IOException e) {
            System.err.println("Error en la ejecución del servidor: " + e.getMessage());
        }

    }
}
