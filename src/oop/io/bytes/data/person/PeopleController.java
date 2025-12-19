package oop.io.bytes.data.person;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

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

    public static void save(Person p) {
        // DataOutputStream dataOutputStream = null;
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("people.dat", true))) {
            //dataOutputStream = new DataOutputStream(new FileOutputStream("people.dat", true));
            dataOutputStream.writeUTF(p.getName());
            dataOutputStream.writeUTF(p.getSurname());
            dataOutputStream.writeDouble(p.getWeight());
            dataOutputStream.writeBoolean(p.isMarried());
            dataOutputStream.writeLong(p.getInn());
            dataOutputStream.writeLong(p.getDate().getTime());
            dataOutputStream.writeUTF(p.getAddress().getCity());
            dataOutputStream.writeUTF(p.getAddress().getStreet());
            dataOutputStream.writeInt(p.getAddress().getHouse());
            if (p.getPhoto() != null) {
                dataOutputStream.writeInt(p.getPhoto().length);
                for (int i = 0; i < p.getPhoto().length - 1; i++) {
                    dataOutputStream.writeByte(i);
                }
            } else dataOutputStream.writeInt(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if (dataOutputStream != null) {
//                try {
//                    dataOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    public static ArrayList<Person> findByName(String name) {

        ArrayList<Person> persons = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("people.dat"))) {
//            dataInputStream = new DataInputStream(new FileInputStream("people.dat"));
            try {
                while (true) {
                    String personsName = dataInputStream.readUTF();
                    String personsSurname = dataInputStream.readUTF();
                    double personsWeight = dataInputStream.readDouble();
                    boolean isPersonsMarried = dataInputStream.readBoolean();
                    long personsInn = dataInputStream.readLong();
                    Date date = new Date(dataInputStream.readLong());
                    String personsCity = dataInputStream.readUTF();
                    String personsStreet = dataInputStream.readUTF();
                    int personsHouse = dataInputStream.readInt();
                    int personPhotoSize = dataInputStream.readInt();
                    byte[] personsPhoto = null;
                    if (personPhotoSize != -1) {
                        personsPhoto = new byte[personPhotoSize];
                        for (int i = 0; i < personPhotoSize - 1; i++) {
                            personsPhoto[i] = dataInputStream.readByte();
                        }
                    }
                    if (name.equals(personsName)) {
                        persons.add(new Person(
                                personsName,
                                personsSurname,
                                personsWeight,
                                isPersonsMarried,
                                personsInn,
                                date,
                                new Address(personsCity, personsStreet, personsHouse),
                                personsPhoto));
                    }
                }
            } catch (EOFException e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if (dataInputStream != null) {
//                try {
//                    dataInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return persons;
    }

    public static Person findByInn(Long inn) {
        Person person = null;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("people.dat"))) {
            try {
                while (true) {
                    String personsName = dataInputStream.readUTF();
                    String personsSurname = dataInputStream.readUTF();
                    double personsWeight = dataInputStream.readDouble();
                    boolean isPersonsMarried = dataInputStream.readBoolean();
                    long personsInn = dataInputStream.readLong();
                    Date date = new Date(dataInputStream.readLong());
                    String personsCity = dataInputStream.readUTF();
                    String personsStreet = dataInputStream.readUTF();
                    int personsHouse = dataInputStream.readInt();
                    int personPhotoSize = dataInputStream.readInt();
                    byte[] personsPhoto = null;
                    if (personPhotoSize != -1) {
                        personsPhoto = new byte[personPhotoSize];
                        for (int i = 0; i < personPhotoSize - 1; i++) {
                            personsPhoto[i] = dataInputStream.readByte();
                        }
                    }
                    if (inn.equals(personsInn)) {
                        person = new Person(
                                personsName,
                                personsSurname,
                                personsWeight,
                                isPersonsMarried,
                                personsInn,
                                date,
                                new Address(personsCity, personsStreet, personsHouse),
                                personsPhoto);
                    }
                }
            } catch (EOFException e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static ArrayList<Person> readAllPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("people.dat"))) {
            try {
                while (true) {
                    String personsName = dataInputStream.readUTF();
                    String personsSurname = dataInputStream.readUTF();
                    double personsWeight = dataInputStream.readDouble();
                    boolean isPersonsMarried = dataInputStream.readBoolean();
                    long personsInn = dataInputStream.readLong();
                    Date date = new Date(dataInputStream.readLong());
                    String personsCity = dataInputStream.readUTF();
                    String personsStreet = dataInputStream.readUTF();
                    int personsHouse = dataInputStream.readInt();
                    int personPhotoSize = dataInputStream.readInt();
                    byte[] personsPhoto = null;
                    if (personPhotoSize != -1) {
                        personsPhoto = new byte[personPhotoSize];
                        for (int i = 0; i < personPhotoSize - 1; i++) {
                            personsPhoto[i] = dataInputStream.readByte();
                        }
                    }
                    persons.add(new Person(
                            personsName,
                            personsSurname,
                            personsWeight,
                            isPersonsMarried,
                            personsInn,
                            date,
                            new Address(personsCity, personsStreet, personsHouse),
                            personsPhoto));
                }
            } catch (EOFException e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static boolean update(Person p) {
        ArrayList<Person> persons = readAllPersons();
        if (persons.remove(p)) {
            persons.add(p);
            return saveAll(persons);
        }
        return false;
    }
//            try {
//                dataOutputStream = new DataOutputStream(new FileOutputStream("people.dat"));
//                for (int i = 0; i < persons.size() - 1; i++) {
//                    dataOutputStream.writeUTF(persons.get(i).getName());
//                    dataOutputStream.writeUTF(p.getSurname());
//                    dataOutputStream.writeDouble(p.getWeight());
//                    dataOutputStream.writeBoolean(p.isMarried());
//                    dataOutputStream.writeLong(p.getInn());
//                    dataOutputStream.writeLong(p.getDate().getTime());
//                    dataOutputStream.writeUTF(p.getAddress().getCity());
//                    dataOutputStream.writeUTF(p.getAddress().getStreet());
//                    dataOutputStream.writeInt(p.getAddress().getHouse());
//                    if (p.getPhoto() != null) {
//                        dataOutputStream.writeInt(p.getPhoto().length);
//                        for (int j = 0; j < p.getPhoto().length - 1; j++) {
//                            dataOutputStream.writeByte(j);
//                        }
//                    } else dataOutputStream.writeInt(-1);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (dataOutputStream != null) {
//                    try {
//                        dataOutputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

    public static boolean delete(Person p) {
        ArrayList<Person> persons = readAllPersons();
        return persons.remove(p) ? saveAll(persons) : false;
    }
//        if (persons.remove(p)) {
//
//            return saveAll(persons);
//        }
//        return false;

    public static boolean saveAll(ArrayList<Person> persons) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("people.dat"))) {
            for (Person p : persons) {
                dataOutputStream.writeUTF(p.getName());
                dataOutputStream.writeUTF(p.getSurname());
                dataOutputStream.writeDouble(p.getWeight());
                dataOutputStream.writeBoolean(p.isMarried());
                dataOutputStream.writeLong(p.getInn());
                dataOutputStream.writeLong(p.getDate().getTime());
                dataOutputStream.writeUTF(p.getAddress().getCity());
                dataOutputStream.writeUTF(p.getAddress().getStreet());
                dataOutputStream.writeInt(p.getAddress().getHouse());
                if (p.getPhoto() != null) {
                    dataOutputStream.writeInt(p.getPhoto().length);
                    for (int j = 0; j < p.getPhoto().length - 1; j++) {
                        dataOutputStream.writeByte(j);
                    }
                } else dataOutputStream.writeInt(-1);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
