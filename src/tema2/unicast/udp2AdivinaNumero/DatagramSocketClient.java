package tema2.unicast.udp2AdivinaNumero;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class DatagramSocketClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc = new Scanner(System.in);

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte[] receivedData = new byte[4];
        byte[] sendingData;

        //a l'inici
        sendingData = getFirstRequest();
        //el servidor atén el port indefinidament
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,
                    sendingData.length,
                    serverIP,
                    serverPort);
            //enviament de la resposta
            socket.send(packet);

            //creació del paquet per rebre les dades
            packet = new DatagramPacket(receivedData, 4);
            //espera de les dades
            socket.receive(packet);
            //processament de les dades rebudes i obtenció de la resposta
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }
        socket.close();
        sc.close();
    }

    private byte[] getDataToRequest(byte[] data, int length) {
        //procés diferent per cada aplicació
        int receivedNum = ByteBuffer.wrap(data).getInt();
        if (receivedNum == 0) {
            System.out.println("Correcto! Lo has adivinado!");
            return ByteBuffer.allocate(4).putInt(-1).array();
        } else if (receivedNum == 1) {
            System.out.println("El número secreto es mas pequeño!");
        } else {
            System.out.println("El número secreto es mas grande!");
        }

        // Solicita el nuevo mensaje
        System.out.println("Introduce tu nuevo numero: ");
        // Lo mandamos transformado en bytes
        return ByteBuffer.allocate(4).putInt(sc.nextInt()).array();
    }

    private byte[] getFirstRequest() {
        // Aquí pide el mensaje por primera vez
        System.out.println("Introduce un número: ");
        // Lo transforma en bytes
        return ByteBuffer.allocate(4).putInt(sc.nextInt()).array();

    }

    private boolean mustContinue(byte[] sendingData) {
        // Lo transforma en String
        int receivedNum = ByteBuffer.wrap(sendingData).getInt();
        // ignora todos los casos excepto él -1
        if (receivedNum == (-1)) {
            return false;
        }
        return true;
    }
}