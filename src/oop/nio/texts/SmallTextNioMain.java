package oop.nio.texts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SmallTextNioMain {
    public static void main(String[] args) {
        String text = "package oop.nio.texts;\n" +
                      "\n" +
                      "import java.io.BufferedReader;\n" +
                      "import java.io.BufferedWriter;\n" +
                      "import java.io.FileNotFoundException;\n" +
                      "import java.io.IOException;\n" +
                      "import java.nio.file.Files;\n" +
                      "import java.nio.file.OpenOption;\n" +
                      "import java.nio.file.Path;\n" +
                      "import java.nio.file.StandardOpenOption;\n" +
                      "import java.text.ParseException;\n" +
                      "import java.text.SimpleDateFormat;\n" +
                      "import java.util.ArrayList;\n" +
                      "import java.util.Date;\n" +
                      "import java.util.List;\n" +
                      "\n" +
                      "public class Controller {\n" +
                      "    private static final Path path = Path.of(\"NioDir/texts/person.txt\");\n" +
                      "\n" +
                      "    public static boolean saveAll(List<Person> personList) {\n" +
                      "        OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};\n" +
                      "        try (BufferedWriter bufferedWriter = new BufferedWriter(Files.newBufferedWriter(path, options))) {\n" +
                      "            for (Person p : personList) {\n" +
                      "                bufferedWriter.append(p + \"\\n\");\n" +
                      "            }\n" +
                      "            return true;\n" +
                      "        } catch (IOException e) {\n" +
                      "            e.printStackTrace();\n" +
                      "        }\n" +
                      "        return false;\n" +
                      "    }\n" +
                      "\n" +
                      "    public static List<Person> readAll() {\n" +
                      "        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(path))) {\n" +
                      "            String buffer = \"\";\n" +
                      "            SimpleDateFormat format = new SimpleDateFormat(\"yyyy-MM-dd\");\n" +
                      "            List<Person> persons = new ArrayList<>();\n" +
                      "            while ((buffer = bufferedReader.readLine()) != null) {\n" +
                      "                long id = Long.parseLong(buffer.split(\" \")[2]);\n" +
                      "                String name = bufferedReader.readLine().split(\" \")[2];\n" +
                      "                String surname = bufferedReader.readLine().split(\" \")[2];\n" +
                      "                String address = bufferedReader.readLine().split(\" \")[2];\n" +
                      "                String phone = bufferedReader.readLine().split(\" \")[2];\n" +
                      "                Date date = format.parse(bufferedReader.readLine().split(\" \")[2]);\n" +
                      "                Gender gender = Gender.valueOf(bufferedReader.readLine().split(\" \")[2]);\n" +
                      "                persons.add(new Person(id, name, surname, address, phone, date, gender));\n" +
                      "            }\n" +
                      "            return persons;\n" +
                      "        } catch (FileNotFoundException e) {\n" +
                      "            e.printStackTrace();\n" +
                      "        } catch (IOException e) {\n" +
                      "            e.printStackTrace();\n" +
                      "        } catch (ParseException e) {\n" +
                      "            e.printStackTrace();\n" +
                      "        }\n" +
                      "        return new ArrayList<>();\n" +
                      "    }\n" +
                      "\n" +
                      "    public static boolean save(Person p) {\n" +
                      "        List<Person> personList = readAll();\n" +
                      "        if (!personList.contains(p)) {\n" +
                      "            personList.add(p);\n" +
                      "            return saveAll(personList);\n" +
                      "        }\n" +
                      "        return false;\n" +
                      "    }\n" +
                      "\n" +
                      "    public static boolean update(Person p) {\n" +
                      "        List<Person> personList = readAll();\n" +
                      "        if (personList.remove(p)) {\n" +
                      "            personList.add(p);\n" +
                      "            return saveAll(personList);\n" +
                      "        }\n" +
                      "        return false;\n" +
                      "    }\n" +
                      "\n" +
                      "    public static boolean delete(Person p) {\n" +
                      "        List<Person> personList = readAll();\n" +
                      "        return personList.remove(p) && saveAll(personList);\n" +
                      "    }\n" +
                      "\n" +
                      "}\n";
        Path path = Path.of("NioDir/texts/file.java");
        try {
            Files.writeString(path, text, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String text1 = Files.readString(path);
            System.out.println(text1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
