package tema2.udp2AdivinaNumero;

import java.io.IOException;
import java.net.*;
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
        byte[] receivedData = new byte[1024];
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
            packet = new DatagramPacket(receivedData, 1024);
            //espera de les dades
            socket.receive(packet);
            //processament de les dades rebudes i obtenció de la resposta
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }
    }

    private byte[] getDataToRequest(byte[] data, int length) {
        //procés diferent per cada aplicació
        String msg = new String(data, 0, length);
        // Mostramos el mensaje
        System.out.println(msg);
        // Solicita el nuevo mensaje
        System.out.println("Introduce tu nuevo mensaje: ");
        String mensaje = sc.nextLine();
        // Lo transforma en bytes
        byte[] mensajeBytes = mensaje.getBytes();

        return mensajeBytes;

    }

    private byte[] getFirstRequest() {
        // Aquí pide el mensaje por primera vez
        System.out.println("Introduce tu nombre: ");
        String mensaje = sc.nextLine();
        // Lo transforma en bytes
        byte[] mensajeBytes = mensaje.getBytes();

        return mensajeBytes;
    }

    private boolean mustContinue(byte[] sendingData) {
        // Lo transforma en String
        String str = new String(sendingData, 0, sendingData.length);

        // ignora todos los casos excepto el adeu
        if (str.equalsIgnoreCase("adeu")) {
            DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
            return false;
        }
        return true;
    }
}