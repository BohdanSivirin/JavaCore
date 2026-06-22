package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeGenerator {
    private static final Random RANDOM = new Random();

    private static final List<String> NAMES = List.of(
            "Alex", "Oleh", "Pavel", "John", "Anna",
            "Maria", "Ivan", "Kate", "Max", "Olga", "Roman", "Dmytro",
            "Igor", "Maxim", "Andriy", "Serhiy"
    );

    public static Manager randomManager() {
        return new Manager(randomId(),
                randomSalary(1000, 10000),
                null,
                randomName(),
                randomBirthDate(30, 55),
                randomWorkDate(3, 15),
                randomSalary(300, 1500)
        );
    }

    public static Worker randomWorker(Manager manager) {
        return new Worker(randomId(),
                randomSalary(1000, 10000),
                manager,
                randomName(),
                randomBirthDate(22, 50),
                randomWorkDate(1, 10),
                randomSalary(500, 2000)
        );
    }

    public static Trainee randomTrainee(Manager manager) {
        return new Trainee(randomId(),
                randomSalary(1000, 10000),
                manager,
                randomName(),
                randomBirthDate(18, 25),
                randomWorkDate(0, 1),
                RANDOM.nextInt(100)
        );
    }

    private static String randomName() {
        return NAMES.get(RANDOM.nextInt(NAMES.size()));
    }

    private static BigDecimal randomSalary(int min, int max) {
        double value = ThreadLocalRandom
                .current()
                .nextDouble(min, max);

        return BigDecimal
                .valueOf(value)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private static LocalDate randomBirthDate(int minAge, int maxAge) {
        int age = RANDOM.nextInt(maxAge - minAge + 1) + minAge;
        return LocalDate.now().minusYears(age);
    }

    private static LocalDate randomWorkDate(int minYears, int maxYears) {
        int years = RANDOM.nextInt(maxYears - minYears + 1) + minYears;
        return LocalDate.now().minusYears(years);
    }

    public static int randomId() {
        return RANDOM.nextInt(0, 1001);
    }
}
