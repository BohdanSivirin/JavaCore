package oop.generic_wildCard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class StorageController<T> {
    private String fileName;

    public StorageController(String fileName) {
        this.fileName = fileName;
    }

    public void save(T t) {
        try {
            Path path = Path.of(fileName);
            OpenOption[] openOptions = {StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
            Files.writeString(path, t.toString(), openOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        try {
            Path path = Path.of(fileName);
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
