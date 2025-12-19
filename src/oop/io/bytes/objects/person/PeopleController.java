package oop.io.bytes.objects.person;

import java.io.*;
import java.util.ArrayList;

public class PeopleController {

    public static byte[] getPhoto(String fileName) {
        //"C:\Users\PC\IdeaProjects\JavaCore\15471.jpg"
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
            byteArrayOutputStream = new ByteArrayOutputStream();

            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(data);
            }
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
            if (byteArrayOutputStream != null)
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : null;
    }

    public static boolean save(Person p) {
        ArrayList<Person> persons = readAllPersons();
        return !persons.contains(p) ? persons.add(p) && saveAll(persons) : false;
    }

    public static ArrayList<Person> readAllPersons() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("People.obj")))) {
            return (ArrayList<Person>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(ArrayList<Person> persons) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("People.obj")))) {
            objectOutputStream.writeObject(persons);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Person p) {
        ArrayList<Person> persons = readAllPersons();
        return persons.remove(p) && saveAll(persons);
    }

    public static boolean update(Person p) {
        ArrayList<Person> persons = readAllPersons();
        return persons.remove(p) && persons.add(p) && saveAll(persons);
    }

    public static Person findByInn(Long inn) {
        ArrayList<Person> persons = readAllPersons();
        for (Person p : persons) {
            if (inn == p.getInn()) {
                return p;
            }
        }
        return null;
    }

}