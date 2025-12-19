package oop.io.adapters.toys;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ToyController {

    public static List<Toy> readAll() {
        List<Toy> toys = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream("toys.zip")))) {
            zipInputStream.getNextEntry();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream));
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                String title = buffer.split(" ")[2];
                buffer = bufferedReader.readLine();
                double price = Double.parseDouble(buffer.split(" ")[2]);
                buffer = bufferedReader.readLine();
                int ageFrom = Integer.parseInt(buffer.split(" ")[2]);
                buffer = bufferedReader.readLine();
                String material = buffer.split(" ")[1];
                buffer = bufferedReader.readLine();
                HashMap<String, Integer> features = new HashMap<>();
                while (!(buffer = bufferedReader.readLine()).startsWith("toxic")) {
                    features.put(
                            buffer.split(" ")[1],
                            Integer.parseInt(buffer.split(" ")[3]));
                }
                boolean isToxic = Boolean.parseBoolean(buffer.split(" ")[2]);
                buffer = bufferedReader.readLine();
                long barcode = Long.parseLong(buffer.split(" ")[2]);
                toys.add(new Toy(title, price, ageFrom, material, isToxic, barcode, features));
            }
            zipInputStream.closeEntry();
            zipInputStream.getNextEntry();
            ObjectInputStream objectInputStream = new ObjectInputStream(zipInputStream);
            List<Toy> cloneToys = ((List<Toy>) objectInputStream.readObject());
            return toys;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(List<Toy> toys) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("toys.zip")))) {
            ZipEntry zipEntry = new ZipEntry("toys.txt");
            zipOutputStream.putNextEntry(zipEntry);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(zipOutputStream));
            for (Toy toy : toys) {
                bufferedWriter.append(toy + "\n");
            }
            bufferedWriter.flush();
            zipOutputStream.closeEntry();

            ZipEntry zipEntry1 = new ZipEntry("toys.obj");
            zipOutputStream.putNextEntry(zipEntry1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream);
            objectOutputStream.writeObject(toys);
            objectOutputStream.flush();
            zipOutputStream.closeEntry();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean save(Toy toy) {
        List<Toy> toys = readAll();
        return !toys.contains(toy) && toys.add(toy) && saveAll(toys);
    }

    public static boolean update(Toy toy) {
        List<Toy> toys = readAll();
        return toys.remove(toy) && toys.add(toy) && saveAll(toys);
    }

    public static boolean delete(Toy toy) {
        List<Toy> toys = readAll();
        return toys.remove(toy) && saveAll(toys);
    }
}
