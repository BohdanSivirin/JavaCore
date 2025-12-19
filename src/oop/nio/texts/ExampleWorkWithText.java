package oop.nio.texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExampleWorkWithText {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\PC\\IdeaProjects\\JavaCore\\factory.txt");
        try {
//            List<String> lines = Files.readAllLines(path);
            List<String> lines = Files.readAllLines(path);
            lines.forEach(t-> System.out.println(t+ " \n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
