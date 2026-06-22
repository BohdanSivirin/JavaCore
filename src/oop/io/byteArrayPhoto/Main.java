package oop.io.byteArrayPhoto;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //"C:\Users\PC\IdeaProjects\JavaCore\15471.jpg"
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("15471.jpg"));
            byteArrayOutputStream = new ByteArrayOutputStream();

            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(data);
            }
            byte[] photoArray = byteArrayOutputStream.toByteArray();
            System.out.println(" photoArray info " +Arrays.toString(photoArray));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (byteArrayOutputStream != null)
                byteArrayOutputStream.close();
        }

    }
}
