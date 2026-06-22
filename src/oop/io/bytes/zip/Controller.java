package oop.io.bytes.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Controller {

    public static ArrayList<BankAccount> findAll() {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream("accounts.zip")))) {
            zipInputStream.getNextEntry();
            DataInputStream dataInputStream = new DataInputStream(zipInputStream);
            try {
                while (true) {
                    long number = dataInputStream.readLong();
                    long id = dataInputStream.readLong();
                    int currency = dataInputStream.readInt();
                    String holder = dataInputStream.readUTF();
                    String clientName = dataInputStream.readUTF();
                    int sum = dataInputStream.readInt();
                    accounts.add(new BankAccount(number, id, currency, holder, clientName, sum));
                }
            } catch (EOFException e) {

            }
            zipInputStream.closeEntry();
            return accounts;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(ArrayList<BankAccount> accounts) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("accounts.zip")))) {
            ZipEntry zipEntry = new ZipEntry("accounts.dat");
            zipOutputStream.putNextEntry(zipEntry);
            DataOutputStream dataOutputStream = new DataOutputStream(zipOutputStream);
            for (BankAccount bankAccount : accounts) {
                dataOutputStream.writeLong(bankAccount.getNumber());
                dataOutputStream.writeLong(bankAccount.getId());
                dataOutputStream.writeInt(bankAccount.getCurrency());
                dataOutputStream.writeUTF(bankAccount.getHolder());
                dataOutputStream.writeUTF(bankAccount.getClientName());
                dataOutputStream.writeInt(bankAccount.getSum());
            }
            zipOutputStream.closeEntry();
            ZipEntry zipEntry1 = new ZipEntry("accounts.obj");
            zipOutputStream.putNextEntry(zipEntry1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream);
            objectOutputStream.writeObject(accounts);
            zipOutputStream.closeEntry();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean save(BankAccount bankAccount) {
        ArrayList<BankAccount> accounts = findAll();
        return !accounts.contains(bankAccount) ? accounts.add(bankAccount) && saveAll(accounts) : false;
    }

    public static boolean update(BankAccount bankAccount) {
        ArrayList<BankAccount> accounts = findAll();
        return accounts.remove(bankAccount) ? accounts.add(bankAccount) && saveAll(accounts) : false;
    }

    public static boolean delete(BankAccount bankAccount) {
        ArrayList<BankAccount> accounts = findAll();
        return accounts.remove(bankAccount) ? saveAll(accounts) : false;
    }

    public static BankAccount findById(long accountId) {
        try (ZipInputStream zipInputStream = new ZipInputStream(
                new BufferedInputStream(
                        new FileInputStream("accounts.zip")))) {
            zipInputStream.getNextEntry();
            DataInputStream dataInputStream = new DataInputStream(zipInputStream);
            long number = dataInputStream.readLong();
            long id = dataInputStream.readLong();
            int currency = dataInputStream.readInt();
            String holder = dataInputStream.readUTF();
            String clientName = dataInputStream.readUTF();
            int sum = dataInputStream.readInt();
            if (id == accountId) {
                return new BankAccount(number, id, currency, holder, clientName, sum);
            }
            zipInputStream.closeEntry();
            zipInputStream.getNextEntry();
            ObjectInputStream objectInputStream = new ObjectInputStream(zipInputStream);
            ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) objectInputStream.readObject();
            for (BankAccount bankAccount : accounts) {
                if (accountId == bankAccount.getId()) {
                    return new BankAccount(
                            bankAccount.getNumber(),
                            bankAccount.getId(),
                            bankAccount.getCurrency(),
                            bankAccount.getHolder(),
                            bankAccount.getClientName(),
                            bankAccount.getSum());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
