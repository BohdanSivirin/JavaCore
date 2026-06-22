package oop.multiTreading.basicSynhroTwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Synhro {
    private BufferedWriter writer;

    public Synhro() {
        try {
            writer = new BufferedWriter(new FileWriter("fileSynchroTwo.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print(String name) {
        for (int i = 0; i <= 3; i++) {
            try {
                writer.append(String.valueOf(i)).append(" ) ").append(name);
                Thread.sleep(1000);
                writer.append(" -> ").append(String.valueOf(i)).append(" | ").append(name).append("\n");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
