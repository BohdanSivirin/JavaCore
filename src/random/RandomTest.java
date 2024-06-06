package random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random generator = new Random();
        boolean b = generator.nextBoolean();
        System.out.println(b);
        int a = generator.nextInt();
        System.out.println(a);
        //-12   17
        a = generator.nextInt(-12, 18); // -12 to 17
        System.out.println(a);
        // сгенерировать 15  случайных чисел от -3 до 12


        int i = 0;
        while (i < 15) {
            a = generator.nextInt(-3, 13);
            System.out.print(a + " ");
            i = i + 1;
        }
        System.out.println("четное =" + a / 3);

        // домашка №1
        // 16 случайных от -15 до 18/ Напечатать только нечетные отрицательные

        i = 0;
        while (i < 16) {
            a = generator.nextInt(-15, 19);
            if (0 > a % 2) {
                System.out.print(" " + a + " ");
            }
            i = i + 1;
        }

        // домашка №2
        //20 случайных от 4 до 22/ Напечатать только кратные 3 числа

        i = 0;
        while (i < 20) {
            a = generator.nextInt(4, 23);
            //System.out.print(" current a = " + a);
            if (a % 3 == 0) {
                System.out.println(" " + a + " ");
            }
            i = i + 1;
        }

        // 1) сгенерить 100 случ чисел от 0 до 160/ 
        // Если число кратное 3 то выписать его и что оно кратно 3
        // Тоже самое для 5 и 15/
        // Но если число кратное 15 то выписывать его кратность 3 и 5 не должно

        System.out.print("--------------------------");
        i = 0;
        while (i < 100) {
            a = generator.nextInt(0, 161);
            if (a % 15 == 0 && a != 0) {
                System.out.println("число " + a + " кратно 15 ");
                continue;
            } else if (a % 5 == 0 && a != 0) {
                System.out.println("число " + a + " кратно 5 ");

            } else if (a % 3 == 0 && a != 0) {
                System.out.println("число " + a + " кратно 3 ");
            }
            i = i + 1;
        }
        System.out.println();
        //2)сгенерить 18 случайных букв
        i = 0;
        while (i < 18) {
            char c = (char) (generator.nextInt(19) + 'a');
            System.out.println(" случайная буква = " + c);
            i = i + 1;
        }
        // генерировать случайные числа от -403 до 350 пока не выпадет 0

        while (true) {
            a = generator.nextInt(-43, 36);
            System.out.print(a + " ");
            if (a == 0) {
                break;
            }
        }

        for (; ; ) {
            a = generator.nextInt(-43, 36);
            System.out.println(a + " ");
            if (a == 0) {
                break;
            }
        }
        //сгенерировать 29 случайных буленей в пропорции 1 к 3 (1 тру на 3 фолса)
        i = 0;
        while (i < 29) {
            a = generator.nextInt(1, 5);
            if (a == 4) {
                System.out.print(true + " ");

            } else {
                System.out.print(false + " ");
            }
            i = i + 1;
        }


        // сгенерировать 20 случ чисел от -14 до 19 / Найти максимум и минимум из сгенерированных
        System.out.print("\n------------------");

        i = 0;
        int max = -14;
        int maxNegative = 19;
        while (i < 20) {
            a = generator.nextInt(-14, 20);
            System.out.print(a + " ");
            if (a > max) {
                max = a;
            }
            if (a < maxNegative) {
                maxNegative = a;
            }
            i = i + 1;
        }
        System.out.print("\n max =" + max + " maxNegative =" + maxNegative);

        // домашка 1
        // сгенерировать 20 случайных гласных букв
//        System.out.print("\n*****************");
//        int vowels = 0;
//        for (i = 0; vowels < 20; i++) {
//            char d = (char) (generator.nextInt(26) + 'a');
//            if (d == 'a' || d == 'e' || d == 'y' || d == 'u' || d == 'i' || d == 'o') {
//                System.out.print(d + " ");
//                vowels++;
//            }
//        }

        int counter = 0;
        int randomIntCharacter = 0;
        char randomCharCharacter = ' ';
        for (i = 0; counter < 20; i = i + 1) {
            randomIntCharacter = generator.nextInt(65, 123);
            if (!(randomIntCharacter > 90 && randomIntCharacter < 97)) {
                randomCharCharacter = (char) randomIntCharacter;
                //System.out.print("\nrandom = " + randomCharCharacter);

                if (randomCharCharacter == 'a' || randomCharCharacter == 'A' || randomCharCharacter == 'e' || randomCharCharacter == 'E' ||
                        randomCharCharacter == 'y' || randomCharCharacter == 'Y' || randomCharCharacter == 'u' || randomCharCharacter == 'U' ||
                        randomCharCharacter == 'i' || randomCharCharacter == 'I' || randomCharCharacter == 'o' || randomCharCharacter == 'O') {
                    System.out.print("\n vowel = " + randomCharCharacter);
                    counter = counter + 1;
                }
            }
        }


//        Bohdan, [27.02.2024 18:04]
//        сгенерировать 20 случайніх кратніх 3 чисел если генерируются в диапазоне от -13 до 18
        System.out.print("\n*****************");

        counter = 0;
        for (i = 0; counter < 20; i++) {
            a = generator.nextInt(-13, 19);

            if (a % 3 == 0 && a != 0) {
                System.out.print(a + " ");
                counter++;
            }
        }



//        2) сгенерить 26 случ чисел в диапазоне от -19 до 23 и найти максимальное отрицательное
        System.out.println(" ");
        System.out.println(" Задание  - 2) сгенерить 26 случ чисел в диапазоне от -19 до 23 и найти максимальное отрицательное");
        maxNegative = 145789;
        for (i = 0; i < 30; i++) {
            a = generator.nextInt(-123633, 145789);
            System.out.print(" " + a);
            if (a < maxNegative) {
                maxNegative = a;
            }
        }
        System.out.println(" ");
        System.out.print("максимальное отрицательное =" + maxNegative);

//
//        Bohdan, [27.02.2024 18:05]
//        3) тоже самое но минимальное положительное

        System.out.print("\n______________________ ");

        int minPositive = 24;
        for (i = 0; i < 26; i++) {
            a = generator.nextInt(-19, 24);
            System.out.print(" " + a);
            if (a > 0 && minPositive > a) {
                minPositive = a;
            }
        }
        System.out.print("минимальное положительное =" + minPositive);

        //сгенерировать 15 случ чисел от -13 до 19. Подсчитать количество положительных
        counter = 0;
        for (i = 0; i < 15; i++) {
            a = generator.nextInt(-13, 20);
            System.out.print(a + " ");
            if (a > 0) {
                counter++;
            }
        }
        System.out.println("counter =" + counter);

        // сгенерировать 12 случайных буленей и сравнить кого больше
        int counterTrue = 0;
        int counterFalse = 0;
        for (i = 0; i < 12; i++) {
            boolean randomboolean = generator.nextBoolean();
            System.out.print(" " + randomboolean);
            if (randomboolean == true) {
                counterTrue++;
            } else {
                counterFalse++;
            }
        }
        if (counterTrue > counterFalse) {
            System.out.println("\ntrue больше");
        } else if (counterFalse > counterTrue) {
            System.out.println("\nfalse больше");
        } else {
            System.out.println("\n Поровну");
        }
        //сгенерировать 16 случайных от -11 до 12/ Найти среднее положительных
        counter = 0;
        int sum = 0;
        double sumResult = 0;
        for (i = 0; i < 16; i++) {
            a = generator.nextInt(-11, 13);
            System.out.print(" " + a);
            if (a >= 0) {
                sum = sum + a;
                counter = counter + 1;
            }
        }
        sumResult = sum * 1.0 / counter;
        System.out.println("\nсреднее арифметическое " + sumResult);


//        Bohdan, [28.02.2024 19:45]
//        1) сгенерировать 16 случ чисел от -17 до 21/ найти количество чисел что не попали в диапазон от -7 до 8

        counter = 0;
        for (i = 0; i < 16; i = i + 1) {
            a = generator.nextInt(-17, 22);
            System.out.print(" " + a + " ");
            if (!(a >= -7 && a <= 8)) {
                counter = counter + 1;
            }
        }
        System.out.print("\n кол-во чисел не попавших в диапазон = " + counter);

//        Bohdan, [28.02.2024 19:45]
//        2) сгенерировать 42 символа с диапазона по аски таблице от 35 до 99/ Каких букв сгенерировалось больше - глпсных или согласных?

        randomIntCharacter = 0;
        randomCharCharacter = ' ';
        int counterVowel = 0;
        int counterConsonant = 0;

        for (i = 0; i < 42; i = i + 1) {
            randomIntCharacter = generator.nextInt(35, 100);

            if ((randomIntCharacter >= 65 && randomIntCharacter <= 90) || (randomIntCharacter >= 97 && randomIntCharacter <= 99)) {
                randomCharCharacter = (char) randomIntCharacter;
                System.out.print("\n random = " + randomCharCharacter);

                if (randomCharCharacter == 'a' || randomCharCharacter == 'A' || randomCharCharacter == 'E' || randomCharCharacter == 'Y'
                        || randomCharCharacter == 'U' || randomCharCharacter == 'I' || randomCharCharacter == 'O') {
                    counterVowel = counterVowel + 1;
                } else {
                    counterConsonant = counterConsonant + 1;
                }
            }
        }
        if (counterVowel > counterConsonant) {
            System.out.println("\n Кол-во гласных больше и равно = " + counterVowel);
        } else if (counterVowel < counterConsonant) {
            System.out.println("\n Кол-во согласных больше и равно = " + counterConsonant);
        } else {
            System.out.println("\n Поровну гласных и согласных");
        }

    }
}

