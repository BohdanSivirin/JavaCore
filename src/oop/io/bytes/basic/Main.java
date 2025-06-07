package oop.io.bytes.basic;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//"C:\Users\PC\IdeaProjects\JavaCore\NЮ - Не получается.mp3"
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("NЮ - Не получается.mp3")));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("copy-NЮ-Не получается.mp3")));

            int data;
            long startTime = System.currentTimeMillis();

            while ((data = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(data);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(" Time of stream : " + (endTime - startTime) / 1000);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
