package oop.nio.bytes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("NioDir/images/15471.jpg");
        try {
            byte[] photo = Files.readAllBytes(path);
            System.out.println("photo: " + Arrays.toString(photo));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
