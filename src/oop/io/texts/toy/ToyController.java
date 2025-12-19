package oop.io.texts.toy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ToyController {
    public static ArrayList<Toy> readAll() {
        ArrayList<Toy> toys = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Toys.txt"))) {
            String buffer = "0";
            while ((buffer = bufferedReader.readLine()) != null) {
//                String[] toysName = buffer.split(" ");
//                String name = toysName[2];
                String title = buffer.split(" ")[2];
                buffer = bufferedReader.readLine();
                double price = Double.parseDouble(buffer.split(" ")[2]);
                buffer = bufferedReader.readLine();
                int ageFrom = Integer.parseInt(buffer.split(" ")[2]);
                buffer = bufferedReader.readLine();
                String material = buffer.split(" ")[1];
                buffer = bufferedReader.readLine();
//                buffer = bufferedReader.readLine();
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
            return toys;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(ArrayList<Toy> toys) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Toys.txt"))) {
            for (Toy toy : toys) {
                bufferedWriter.append(toy + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean save(Toy toy) {
        ArrayList<Toy> toys = readAll();
        return !toys.contains(toy) && toys.add(toy) && saveAll(toys);
    }

    public static ArrayList<Toy> findAvailableToys(int ageFrom, int ageTo) {
        ArrayList<Toy> availableToys = new ArrayList<>();
        ArrayList<Toy> toys = readAll();
        for (Toy toy : toys) {
            if (toy.getAgeFrom() >= ageFrom && toy.getAgeFrom() <= ageTo) {
                availableToys.add(toy);
            }
        }
        return availableToys;
    }

    public static boolean delete(Toy toy) {
        ArrayList<Toy> toys = readAll();
        return toys.remove(toy) && saveAll(toys);
    }

    public static boolean update(Toy toy) {
        ArrayList<Toy> toys = readAll();
        return toys.remove(toy) && toys.add(toy) && saveAll(toys);
    }


}
