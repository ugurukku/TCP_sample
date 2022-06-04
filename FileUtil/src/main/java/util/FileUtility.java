/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author HPProbook4530s
 */
public class FileUtility {

    public static void writeObjectToFile(Serializable object, String fileName) throws RuntimeException {
        try (FileOutputStream fout = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static Object readFileDeserialize(String fileName) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = ois.readObject();
        } finally {
            return obj;
        }
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();
        System.out.println("Done.");
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            byte[] bytesArray = new byte[(int) file.length()];
            fileInputStream.read(bytesArray);
            return bytesArray;
        }
    }

}
