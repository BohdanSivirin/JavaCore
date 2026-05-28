package oop.functionalProgramming;

import oop.functionalProgramming.jsonEmployee.Employee;
import oop.functionalProgramming.jsonEmployee.Payroll;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.DoubleBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //используя интерфейс Supplier, сгенерировать случайный пароль из 7 символов, но чтобы обязательно в нем были маленькая
        // и большая буквы, цифра и хоть один спецсимвол
        Supplier<String> pass = () -> {
            char number = (char) new Random().nextInt('0', '9');
            char lowCase = (char) new Random().nextInt('a', 'z');
            char upperCase = (char) new Random().nextInt('A', 'Z');
            char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', '=', '+'};
            char randomSymbol = symbols[new Random().nextInt(symbols.length)];

            StringBuilder password = new StringBuilder();
            password.append(number).append(lowCase).append(upperCase).append(randomSymbol);

            for (int i = 0; i < 3; i++) {
                password.append((char) new Random().nextInt(33, 127));
            }
            char[] arr = password.toString().toCharArray();

            for (int i = 0; i < arr.length; i++) {
                int r = new Random().nextInt(arr.length);
                char buffer = arr[i];
                arr[i] = arr[r];
                arr[r] = buffer;
            }
            return String.valueOf(arr);
        };
        System.out.println("Result - " + pass.get());

        class Banner {
            private String title;
            private String someData;

            Banner(String title, String someData) {
                this.title = title;
                this.someData = someData;
            }
        }

        ArrayList<Banner> banners = new ArrayList<>();
        banners.add(new Banner("Black", "BlackData"));
        banners.add(new Banner("White", "WhiteData"));
        banners.add(new Banner("Red", "RedData"));
        banners.add(new Banner("Yellow", "YellowData"));
        banners.add(new Banner("Blue", "BlueData"));

        int[] index = {-1};
        Supplier<Banner> getNextBanner = () -> {
            index[0]++;
            if (index[0] == banners.size()) {
                index[0] = 0;
            }
            return banners.get(index[0]);
        };
        for (int i = 0; i < 8; i++) {
            Banner banner = getNextBanner.get();
            System.out.println("banner # " + i + ", title: " + banner.title);
        }
        //есть лист с товарами (название  цена  количество). Используя интерфейс Консьюмер, сделать дискаунт на товары,
        // общая стоимость которых выше той, что в некой переменной. Потом рпспечатать товары

        Good good = new Good("Casio", 1, new BigDecimal("3258.33"));
        Good good1 = new Good("Atlantic", 4, new BigDecimal("4598.12"));
        Good good2 = new Good("Diesel", 3, new BigDecimal("1010.25"));
        Good good3 = new Good("Fossil", 4, new BigDecimal("6358.22"));
        Good good4 = new Good("J.Springs", 7, new BigDecimal("5124.16"));
        Good good5 = new Good("Lotus", 13, new BigDecimal("1388.36"));
        Good good6 = new Good("Medan", 8, new BigDecimal("1248.99"));
        Good good7 = new Good("Orient", 2, new BigDecimal("9874.23"));
        BigDecimal edgePrice = new BigDecimal("10000");
        List<Good> list = Arrays.asList(good, good1, good2, good3, good4, good5, good6, good7);
        for (Good g : list) {
            System.out.println(g);
        }
        System.out.println(" --------------- ");
        System.out.println("After discounted price ");

        Consumer<Good> discountPrice = (Good currentGood) -> {
            if (currentGood.total().compareTo(edgePrice) > 0) {
                BigDecimal newPrice = currentGood.getPrice().multiply(BigDecimal.valueOf(0.9));
                BigDecimal roundingNewPrice = newPrice.setScale(2, RoundingMode.HALF_UP);
                currentGood.setPrice(roundingNewPrice);
                currentGood.setHasDiscount(true);
            }
        };
        for (Good g : list) {
            discountPrice.accept(g);
            System.out.println(g);
        }
        //есть некий список сотрудников (имя номер должность, зарплата) . используя саплайера найти в списке сотружников того, у которого наибольшая зарплата
        Employer employer = new Employer("David", 1, "CEO", 12598.56);
        Employer employer1 = new Employer("Boris", 2, "CFO", 16898.23);
        Employer employer2 = new Employer("Oleh", 3, "Віцепрезидент", 19568.22);
        Employer employer3 = new Employer("Ihor", 4, "Адміністратор", 17258.33);
        Employer employer4 = new Employer("Leo", 5, "Директор філії", 23598.76);
        Employer employer5 = new Employer("Luka", 6, "CMO", 22598.66);
        Employer employer6 = new Employer("Sveta", 7, "Помічник керівника", 19788.26);
        Employer employer7 = new Employer("Nataly", 8, "Супервайзер", 25688.26);
        List<Employer> employers = Arrays.asList(employer, employer1, employer2, employer3, employer4, employer5, employer6, employer7);
        Supplier<Employer> getEmployerWithHigestSalary = () -> {
            Employer buffer = employers.get(0);
            for (int i = 0; i < employers.size(); i++) {
                if (employers.get(i).getSalary() > buffer.getSalary()) {
                    buffer = employers.get(i);
                }
            }
            return buffer;
        };
        System.out.println(getEmployerWithHigestSalary.get());
        //Написать консьюмера, который умеет сохранять и добавлять в текстовый файл сотрудников
        Consumer<Employer> saveEmployer = (Employer currentEmployer) -> {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("workers.txt", true)))) {
                writer.append(currentEmployer.toString()).append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        saveEmployer.accept(employer3);
        saveEmployer.accept(employer5);
        saveEmployer.accept(employer7);
        //используя саплаера выдавать случайное 18 значное целое число
        Supplier<Long> generateLongNumber = () -> new Random().nextLong(100000000000000000L, 999999999999999999L);
        System.out.println("generateLongNumber: " + generateLongNumber.get());
        //есть эрейлист с стрингами, удалить из него все стринги, короче стольки-то символов
        List<String> string = new ArrayList<>();
        Collections.addAll(string,
                "good",
                "12345",
                "123456",
                "qwerty123",
                "NatalyNataly",
                "new Good(\"Casio\", 1, 3258.33);",
                "Неправильный источник скидки");
        int edge = 6;
        for (int i = 0; i < string.size(); i++) {
            int currentLength = string.get(i).length();
            if (currentLength < edge) {
                string.remove(string.get(i--));
            }
        }
        System.out.println(string);
        // используя интерфейс Предикейт протестировать стринг на отсутствие в нем цифр(если нет - то все ок!)
        Predicate<String> hasNumbers = (String text) -> {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    return false;
                }
            }
            return true;
        };
        boolean isNatalyHasNumbers = hasNumbers.test("NatalyNataly");
        System.out.println("isNatalyHasNumbers " + isNatalyHasNumbers);

        boolean isNatalyHasNumbers2 = hasNumbers.test("NatalyNataly567");
        System.out.println("isNatalyHasNumbers 2 " + isNatalyHasNumbers2);
        //есть эрейлист интов, используя метод форич эрейлиста, распечатать его
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 3, 4, 5, 6, 7, 8, 9, 235, 777, 999);
        Consumer<Integer> action = (Integer i) -> System.out.println(i);
        integerList.forEach(action);
        //есть эрейлист интов. Удалить у него отрицательные элементы используя метод removeIf
        List<Integer> negativeNumbers = new ArrayList<>();
        Collections.addAll(negativeNumbers, -10, 1, 8, -99, 3, -45, -125, -987, 5, 6, 7, 8, 9, 235, 777);

        Predicate<Integer> removeNegative = (Integer j) -> j < 0;
//        negativeNumbers.removeIf(removeNegative);

        negativeNumbers.removeIf((Integer j) -> j < 0);
        System.out.println(negativeNumbers);

        Car car = new Car("Bmw", 2.0, 225, "x6", 2015);
        Car car1 = new Car("Bmw", 2.5, 325, "x7", 2023);
        Car car2 = new Car("Audi", 3.5, 500, "q8", 2026);
        Car car3 = new Car("Skoda", 2.1, 190, "a7", 2010);
        Car car4 = new Car("Skoda", 5.5, 1290, "yeti", 2002);
        Car car5 = new Car("Mercedes", 3.3, 110, "clk", 1997);
        Car car6 = new Car("Mercedes", 3.5, 120, "amg", 2010);
        List<Car> cars = new ArrayList<>();
        Collections.addAll(cars, car, car1, car2, car3, car4, car5, car6);
        Predicate<Car> filterYear = current -> current.getYear() >= 2010 && current.getYear() <= 2016;
        Predicate<Car> filterVolume = (current) -> current.getVolume() >= 2.0 && current.getVolume() <= 3.5;
        Predicate<Car> filterModel = (Car current) -> current.getModel().equals("x6") || current.getModel().equals("amg");

        Predicate<Car> filteredCar = filterYear.and(filterVolume).and(filterModel);
        cars.removeIf(filteredCar.negate());
        cars.forEach(c -> System.out.println(c));

        System.out.println("* * * * ");
        //Используя интерфейс Function, преобразовать лист стрингов в лист интов, в котором в каждой ячейке стоит количество цифр в каждом стринге
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "v3b8", "ascg2", "qwerty1234", "h6>?", "hello", "amg99", "369*", "+38069");
//        strings.forEach(t -> System.out.println(t));

        Function<String, Integer> transform = t -> getStringValue(t);
        List<Integer> integers = new ArrayList<>();
        Consumer<String> findNumbers = (t) -> integers.add(getStringValue(t));
        Consumer<Integer> print = (i) -> System.out.println(i + " ");

//        for(String t: strings){
//            integers.add(transform.apply(t));
//        }

        strings.forEach(findNumbers);
        integers.forEach(print);

        String root = "Dir/Emploeey/json/emloeey";

        Function<String, List<Employee>> jsonParser = (String fileName) -> {
            List<Employee> employeeList = new ArrayList<>();
            try {
                List<String> lines = Files.readAllLines(Path.of(fileName));
                Stream<String> lines2 = Files.lines(Path.of(fileName));
//                lines.forEach(t -> System.out.println(t));
                lines.removeIf(l -> l.equals("["));
                lines.removeIf(l -> l.equals("]"));
                lines.removeIf(l -> l.trim().equals("{"));
                lines.removeIf(l -> l.trim().equals("},"));
                System.out.println(" after remove ");
                lines.forEach(t -> System.out.println(t));
                int id = -1;
                String name = "";
                double salary = -1.0;
                int age = -1;
                String position = "";
                int exp = -1;
                for (int i = 0; i < lines.size(); ) {
                    String idStringLine = lines.get(i);
                    String idValue = idStringLine.trim().split(":")[1];
                    String idCleanedValue = idValue.substring(0, idValue.length() - 1);
                    id = Integer.parseInt(idCleanedValue);

                    String nameStringLine = lines.get(++i);
                    String nameValue = nameStringLine.trim().split(":")[1];
                    name = nameValue.substring(1, nameValue.length() - 2);

                    String salaryStringLine = lines.get(++i);
                    String salaryValue = salaryStringLine.trim().split(":")[1];
                    String salaryCleanedValue = salaryValue.substring(0, salaryValue.length() - 1);
                    salary = Double.parseDouble(salaryCleanedValue);

                    String ageStringLine = lines.get(++i);
                    String ageValue = ageStringLine.trim().split(":")[1];
                    String ageCleanedValue = ageValue.substring(0, ageValue.length() - 1);
                    age = Integer.parseInt(ageCleanedValue);

                    String positionStringLine = lines.get(++i);
                    String positionValue = positionStringLine.trim().split(":")[1];
                    position = positionValue.substring(1, positionValue.length() - 2);

                    String expStringLine = lines.get(++i);
                    String expValue = expStringLine.trim().split(":")[1];
                    exp = Integer.parseInt(expValue);

                    employeeList.add(new Employee(id, name, salary, age, position, exp));
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return employeeList;
        };
        List<Employee> employeeList = jsonParser.apply(root);
        System.out.println(" jsonParser.apply(root) return data ");
        employeeList.forEach(e -> System.out.println(e));

        //sum == 80% salary + 20% from exp
        Function<Employee, Payroll> calculateSum = (Employee e) ->
                new Payroll(e.getId(), e.getSalary() * 0.8 + ((e.getExp() * 0.2) * e.getSalary()));
        List<Payroll> payrollList = new ArrayList<>();
        employeeList.forEach(e -> payrollList.add(calculateSum.apply(e)));
        payrollList.forEach(l -> System.out.println(l));
        //есть лист стрингов, сделать так, чтобы в листе все стринги начинались с большой буквы. Используем метод листа риплейсОлл (вася - Вася  киев  Киев)
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "v3b8", "ascg2", "qwerty1234", "h6>?", "hello", "amg99", "369*", "+38069", "киев", "vasya");
        UnaryOperator<String> upperFirstLetter = (String t) ->
                t.replace(t.substring(0, 1), t.substring(0, 1).toUpperCase());

        stringList.replaceAll(upperFirstLetter);
        stringList.forEach(s -> System.out.println(s));
        //используя БинариОператор определить сумму элементов в массиве
        int[] nums = {1, 4, 6, 10, 3};
        Integer currentSum = 0;
        BinaryOperator<Integer> sum = (Integer i, Integer y) -> i + y;

        for (int i = 0; i < nums.length; i++) {
            currentSum = sum.apply(currentSum, nums[i]);
        }
        System.out.println(currentSum);
//в листе типа инт найти максимальный элемент используя БинариОператор
        List<Integer> integerList1 = new ArrayList<>();
        Collections.addAll(integerList1, 12, 58, 99, 102, 101, 32, 65, -78, 3, 35, 103);
        BinaryOperator<Integer> maxValue = (Integer a, Integer b) -> a > b ? a : b;
        Integer result = 0;
        for (Integer i : integerList1) {
            result = maxValue.apply(result, i);
        }
        System.out.println(result);
        //есть лист стрингов, отсортировать его по алфавиту по убыванию (от я до а)
        System.out.println(" по алфавиту по убыванию (от я до а)\n ");
        List<String> list1 = Arrays.asList("Яблоко", "Апельсин", "Груша", "Вишня", "Киев", "Например", "Двери", "Окна", "Яша");
        list1.sort(Comparator.reverseOrder());
        list1.forEach(t -> System.out.print(t + " \n"));
        //отсортировать по количеству символов
//        list1.sort((l1, l2) -> {
//            if (l1.length() > l2.length()) return 1;
//            if (l1.length() < l2.length()) return -1;
//            return 0;
//        });
        list1.sort((l1, l2) -> l1.length() - l2.length());
        System.out.println(" по количеству символов \n");
        list1.forEach(t -> System.out.println(t + " "));

        // есть мапа типа Стринг - Интежер. Используя форич найти среднее положительных значений
        Map<String, Integer> map = Map.of(
                "Яблоко", 3,
                "Апельсин", 22,
                "Груша", 45,
                "Вишня", -12,
                "Черешня", 66,
                "Арбуз", 103,
                "Киви", 11);
        final int[] currentAverageValue = {0, 0};

        BiConsumer<String, Integer> averageValue = (key, value) -> {
            if (value > 0) {
                currentAverageValue[0] += value;
                currentAverageValue[1]++;
            }
        };
        map.forEach(averageValue);
        System.out.println("currentAverageValue: " + currentAverageValue[0] + " positive numbers: " + currentAverageValue[1]);
        double roundAverage = Math.round((double) currentAverageValue[0] / currentAverageValue[1]*100)/100.0;
        System.out.println("average result: " + roundAverage);
        System.out.printf(" average result formatted: %.2f\n",(double) currentAverageValue[0] / currentAverageValue[1]);
        System.out.println(" q134 ");
        // map.forEach((k, v) -> System.out.println(k + " " + v + " "));

    }

    public static int getStringValue(String t) {
        int counter = 0;
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                counter++;
            }
        }
        return counter;
    }
}
