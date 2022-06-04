package tcpserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.SneakyThrows;
import util.FileUtility;

public class TCPServer {

    public static void main(String[] args) {
        readAsByte();
    }

    @SneakyThrows
    public static void readAsByte() {
        ServerSocket ourFirstServerSocket = new ServerSocket(8989);
        while (true) {
            System.out.println("Waiting");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("urra");
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(dataStream);
            System.out.println("message length2= " + arr.length);
            FileUtility.writeBytes("C:/Users/HPProbook4530s/Desktop/salamqwer.jpg", arr);
        }
    }

    @SneakyThrows
    public static byte[] readMessage(DataInputStream din) {
        int msgLen = din.readInt();
        System.out.println("message length1= " + msgLen);
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }

    @SneakyThrows
    public static void readAsString() {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            Socket connection = ourFirstServerSocket.accept();

            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);

            String messageFromClient = bReader.readLine();
            System.out.println("message from client= " + messageFromClient);
        }
    }
}
