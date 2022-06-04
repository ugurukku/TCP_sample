package tcpclient;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import lombok.SneakyThrows;
import util.FileUtility;

public class TCPClient {

    @SneakyThrows
    public static void main(String[] args) {
        Socket socket = new Socket("localhost", 6789);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte[] bytes = FileUtility.readBytes("C:/Users/HPProbook4530s/silecembunu/4.jpg");
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }
}
