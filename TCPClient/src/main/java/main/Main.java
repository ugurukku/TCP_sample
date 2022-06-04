/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import lombok.SneakyThrows;
import util.FileUtility;

/**
 *
 * @author HPProbook4530s
 */
public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        Socket socket = new Socket("localhost", 8989);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte[] b = FileUtility.readBytes("C:/Users/HPProbook4530s/silecembunu/4.jpg");
        dataOutputStream.writeInt(b.length);
        dataOutputStream.write(b);
        socket.close();

    }

    @SneakyThrows
    public static void test1() {
        while (true) {
            Socket socket = new Socket("localhost", 6789);
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            Scanner sc = new Scanner(System.in);
            String txt = sc.nextLine();
            outputStream.write(txt.getBytes());
            outputStream.close();
        }
    }
}
