package tema2.unicast.udp2AdivinaNumero;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

// https://github.com/elpuig-dam/mp9-nf2-2627/blob/main/mp9.nf2.udp/TODO.md
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

        // Transformo el array de Bytes a int
        int receivedNum = ByteBuffer.wrap(data).getInt();
        System.out.println("Número recibido: " + receivedNum);
        // Comprueba el número y devuelve 0,1,2.
        int sendNum = numeroSecret.comprova(receivedNum);
        // Devuelve sendNum con formato byte[]
        return ByteBuffer.allocate(4).putInt(sendNum).array();

    }
}