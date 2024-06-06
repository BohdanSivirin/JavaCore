package scanner;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write int = ");
//        int number = scanner.nextInt();
//        System.out.println(number);
//        System.out.println("Write double = ");
//        double number1 = scanner.nextDouble();
//        System.out.println(number1);
//        System.out.println("Write text = ");
//        String someText = scanner.next(); // one word - // scanner.nextLine - many word
//        System.out.println(someText);
//        int[] arr = returnArray();
//        System.out.println(Arrays.toString(arr));
        //randomNumber();
        rewriteArrFromMinToMax(
                new int[][]{
                        {-55, 15, -5, 0, 999, 5, 112,},
                        {1, 5, -278, -90, 100},
                        {4, 52, -78, -85, -8, 12, -77},
                        {-55, 123, -4578, 3, 7}},
                new int[][]{
                        {99, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {-1, -2, -3, -4, -5, -6},
                        {-7, -8, 9, -10, -11, -12}});
        boolean result = CheckIfElementsIsDifferent(
                new int[][]{{-55, 15, -5, 0, 999, 5, 112,},
                        {1, 5, -278, -90, 100},
                        {4, 52, -78, -85, -8, 12, -77},
                        {-55, 123, -4578, 3, 7}},
                new int[]{99, 2, 33, 14, 25, 6});
        System.out.println(result);
        findSecondMax(new int[][]{
                {-55, 15, -5, 0, 29, 5, 112,},
                {1, 5, -278, -90, 100},
                {4, 52, -78, -85, -8, 12, -77},
                {-55, 123, -4578, 3, 7}, {99, 2, 33, 14, 25, 6, 367}});
    }

    //ф-я запрашивает длину массива, создает массив такой длины и заставляет заполнить его с клавиатуры только
    // положительными нечетными числами и возвращает результир массив
    public static int[] returnArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a size of Array = ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Write a number to input in Array");

        for (int i = 0; i < array.length; i++) {
            int inputNumber = scanner.nextInt();
            if ((inputNumber > 0) && (inputNumber % 2 != 0)) {
                array[i] = inputNumber;
                System.out.println("Write one more number");
            } else {
                System.out.println("Write a correct number");
                i--;
            }
        }
        return array;
    }

    //ф-я загадывает случайное число и озвучивает диапазон,
    // в котором это число. Если пользователь введет больше чем загадано, ф-я скажет что число меньше и наоборот.
    // После 3-х неправильных вводов начинаются китайские предупреждения (1-е, потом второе и  т д)

    public static void randomNumber() {
        Random random = new Random();
        int startOfRange = random.nextInt(0, 40);
        int endOfRange = random.nextInt(50, 100);
        int a = random.nextInt(startOfRange, endOfRange);

        System.out.println("Угадай загаданное число в диапазоне - От " + startOfRange + " До " + endOfRange);
        // System.out.println(a);

        Scanner scanner = new Scanner(System.in);
        for (int i = 0, k = 1; ; i++) {
            System.out.println("Введите число = ");
            int inputNumber = scanner.nextInt();
            if (inputNumber < a) {
                System.out.println(" Загаданное число больше ");
            } else if (inputNumber > a) {
                System.out.println(" Загаданное число меньше ");
            } else {
                System.out.println(" Congratulations !!! ");
                break;
            }
            if (i > 2) {
                System.out.println(" " + k + " Китайское предупреждение )) ");
                k++;
            }
        }
    }

    // 1)ф-я принимает два 2д массива типа инт и делает так, чтобы с первого по второй все числа стали по увеличению

    public static void rewriteArrFromMinToMax(int[][] arr1, int[][] arr2) {
        System.out.println("ф-я принимает два 2д массива типа инт и делает так, чтобы с первого по второй все числа стали по увеличению");
        int counterarr1 = 0;
        int counterarr2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            counterarr1 = counterarr1 + arr1[i].length;
        }
        for (int i = 0; i < arr2.length; i++) {
            counterarr2 = counterarr2 + arr2[i].length;
        }
        int[] buffer = new int[counterarr1 + counterarr2];

        System.out.println(counterarr1);
        System.out.println(counterarr2);
        System.out.println(buffer.length);

        for (int i = 0, k = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                buffer[k++] = arr1[i][j];
            }
        }
        for (int i = 0, k = buffer.length - 1; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                buffer[k--] = arr2[i][j];
            }
        }
        System.out.println(Arrays.toString(buffer));
        Arrays.sort(buffer);
        System.out.println(Arrays.toString(buffer));

        for (int i = 0, k = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = buffer[k++];
            }
        }
        for (int i = 0, k = counterarr1; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = buffer[k++];
            }
        }
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2));

    }

// 1) ф-я принимает квадратній 2д массив и печатает триугольником все что под и на диагонали (но противоположной) - доделать

    // 2)принимаем 2д массив и еще один 1д массив и возвращаем тру: если в 2д массиве нет єлементов таких: как в 1д массиве
    public static boolean CheckIfElementsIsDifferent(int[][] arr1, int[] arr2) {
        System.out.println("arr 1 = " + Arrays.deepToString(arr1));
        System.out.println("arr 2 = " + Arrays.toString(arr2));
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                int buffer = arr1[i][j];
                for (int k = 0; k < arr2.length; k++) {
                    if (buffer == arr2[k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    // 3)принимаем 2д массив и возвращаем второй максимум (использовать только цикл)

    public static int findSecondMax(int[][] arr) {
        int firstMax = arr[0][0];
        int secondMax = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > firstMax) {
                    secondMax = firstMax;
                    firstMax = arr[i][j];
                }
                else if ((firstMax >= arr[i][j]) && (arr[i][j] > secondMax)){
                    secondMax = arr[i][j];
                }
            }
        }
        System.out.println("max1 = " + firstMax);
        System.out.println("max2 = " + secondMax);
        return secondMax;
    }
}