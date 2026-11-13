package tema2.udp2AdivinaNumero;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
// https://github.com/elpuig-dam/mp9-nf2-2627/blob/main/mp9.nf2.udp/TODO.md
// TODO continuar el ejercicio. Solo he duplicado el ejercicio anterior
//  y añadido la clase e invocación de SecretNum.
public class DatagramSocketServer {
    DatagramSocket socket;
    SecretNum numeroSecret;

    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
        this.numeroSecret = new SecretNum(100);
    }

    public void runServer() throws IOException {

        byte[] receivingData = new byte[4];
        byte[] sendingData;
        InetAddress clientIP;
        int clientPort;


        //el servidor atén el port indefinidament
        while (true) {
            //creació del paquet per rebre les dades
            DatagramPacket packet = new DatagramPacket(receivingData, 4);

            //espera de les dades
            socket.receive(packet);

            //processament de les dades rebudes i obtenció de la resposta
            sendingData = processData(packet.getData(), packet.getLength());

            //obtenció de l'adreça del client
            clientIP = packet.getAddress();

            //obtenció del port del client
            clientPort = packet.getPort();

            //creació del paquet per enviar la resposta
            packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);

            //enviament de la resposta
            socket.send(packet);
        }
    }

    private byte[] processData(byte[] data, int length) {

        // Transformo el array de Bytes a String
        String msg = new String(data, 0, length);

        System.out.println("Client: " + msg);

        // Paso el String a mayúsculas.
        String msgUp = msg.toUpperCase();

        // Imprimo el string en mayusculas.
        System.out.println("Server: " + msgUp);

        // Creamos el paquete para enviar.
        byte[] reSendData = msgUp.getBytes();


        return reSendData;
    }
}