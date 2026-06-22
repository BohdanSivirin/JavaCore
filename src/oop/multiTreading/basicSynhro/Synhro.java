package oop.multiTreading.basicSynhro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Synhro {
    private BufferedWriter writer;

    public Synhro() {
        try {
            writer = new BufferedWriter(new FileWriter("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String text) {
        try {
            writer.append(text);
        } catch (IOException e) {
            e.printStackTrace();
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
