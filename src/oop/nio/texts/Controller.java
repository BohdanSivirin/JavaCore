package oop.nio.texts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private static final Path path = Path.of("NioDir/texts/person.txt");

    public static boolean saveAll(List<Person> personList) {
        OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        try (BufferedWriter bufferedWriter = new BufferedWriter(Files.newBufferedWriter(path, options))) {
            for (Person p : personList) {
                bufferedWriter.append(p + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Person> readAll() {
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(path))) {
            String buffer = "";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            List<Person> persons = new ArrayList<>();
            while ((buffer = bufferedReader.readLine()) != null) {
                long id = Long.parseLong(buffer.split(" ")[2]);
                String name = bufferedReader.readLine().split(" ")[2];
                String surname = bufferedReader.readLine().split(" ")[2];
                String address = bufferedReader.readLine().split(" ")[2];
                String phone = bufferedReader.readLine().split(" ")[2];
                Date date = format.parse(bufferedReader.readLine().split(" ")[2]);
                Gender gender = Gender.valueOf(bufferedReader.readLine().split(" ")[2]);
                persons.add(new Person(id, name, surname, address, phone, date, gender));
            }
            return persons;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean save(Person p) {
        List<Person> personList = readAll();
        if (!personList.contains(p)) {
            personList.add(p);
            return saveAll(personList);
        }
        return false;
    }

    public static boolean update(Person p) {
        List<Person> personList = readAll();
        if (personList.remove(p)) {
            personList.add(p);
            return saveAll(personList);
        }
        return false;
    }

    public static boolean delete(Person p) {
        List<Person> personList = readAll();
        return personList.remove(p) && saveAll(personList);
    }

}
