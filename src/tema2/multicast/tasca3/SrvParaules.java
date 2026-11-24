package tema2.multicast.tasca3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class SrvParaules {

    MulticastSocket socket;
    InetAddress multicastIP;
    int port;
    boolean continueRunning = true;
    ArrayList<String> llista = new ArrayList<>();

    public SrvParaules(int portValue, String strIp) throws IOException {
        socket = new MulticastSocket(portValue);
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;

    }

    public void runServer() throws IOException {
        llista.add("Chicle");
        llista.add("Albondiga");
        llista.add("Bombilla");
        llista.add("Sombrilla");
        llista.add("Cable");


        DatagramPacket packet;
        byte[] sendingData;

        while (continueRunning) {

            String palabra = llista.get((int) (Math.random() * llista.size()));

            sendingData = palabra.getBytes();

            packet = new DatagramPacket(sendingData, sendingData.length, multicastIP, port);
            socket.send(packet);

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }


        }
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        //Que no sigui la mateixa que la d'un altre company
        SrvParaules srvVel = new SrvParaules(5557, "224.3.11.115");
        srvVel.runServer();
        System.out.println("Parat!");

    }

}