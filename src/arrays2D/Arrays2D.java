package arrays2D;

import java.util.Arrays;
import java.util.Random;

public class Arrays2D {
    public static void main(String[] args) {
        int[][] array =
                {{3, 8, 4},
                        {5, 7},
                        {9, 1, 6, 0},
                        {4}};
        System.out.println(array.length);
        System.out.println(array[1][1]);
        array[2][2] = 17;
        System.out.println(Arrays.deepToString(array));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();

        int[][] matrix = new int[3][3];
        System.out.println(Arrays.deepToString(matrix));

        //есть 2д массив типа инт/ найти максимум и минимкм в нем
        int max = array[0][0];
        int min = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        System.out.println("max значение = " + max);
        System.out.println("min значение = " + min);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("//ф-я принимает массив 2д а возвращает 1д массив с элементов этого 2д = "
                + Arrays.toString(array1DFrom2D(new int[][]{{3, 8, 4}, {5, 7}, {9, 1, 6, 0}, {4, 5, 45}})));
        cardArray(new int[][]{{100, 200, 300}, {66}, {12, 14, 23, 1}, {55}, {1, 5, 78, 90}});
        System.out.println("ф-я принимает 2 инта и возвращает массив 2д с такими размерами. заполненный только случ нечетными отрицат числами с диапазона от -12 до 15 = "
                + Arrays.deepToString(matrix(12, 5)));
        System.out.println("HW 1 - принимаем 2д массив и возвращаем 1д с только положительными элементами переданного 2д = "
                + Arrays.toString(checkOnlyPositive(new int[][]{{55, -15, -5, 0, 999, 2546, 7}, {1, 5, -278, 90}, {4, 78, -85, -8}, {55}, {-1, 5, 0, 3}})));
        System.out.println("//HW 2 - принимаем 2д массив и возвращаем среднее его положительных элементов в нечетных строках = "
                + averagePositiveOddLine(new int[][]{{-55, -15, -5, 0, 999, -2546, -7}, {1, 5, -278, -90}, {4, -78, -85, -8}, {-55}, {-1, 5, 0, 3}}));
        System.out.println("// HW 3 - ф-я принимает 2д массив и возврашает среднее значений на четных строках = "
                + averagePositiveEvenLine(new int[][]{{-55, -15, -5, 0, 999, -2546, -7}, {1, 5, -278, -90}, {4, -78, -85, -8}, {-55, 123, -4578, 3, 7}, {-1, 5, 0, 3}, {1, 4, 7, 9}}));
        printMiddleArray(new int[][]{{-55, -15, -5, 0, 999,},
                {1, 5, -278, -90, 100},
                {4, 52, -78, -85, -8},
                {-55, 123, -4578, 3, 7}});
        printBooblyk(new int[][]{
                {-55, -15, -5, 0, 999,},
                {1, 5, -278, -90, 100},
                {4, 52, -78, -85, -8},
                {-55, 123, -4578, 3, 7}});
        printTriangle(new int[][]{
                {-55, -15, -5, 0},
                {1, 5, -278, -90},
                {4, 52, -78, -85},
                {-55, 123, 8, 7}});
        System.out.println("// HW 4 - ф-я принимает прямоугольный 2д массив и создает его точную копию и возвращает эту копию = " + Arrays.deepToString(copy2DArray(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {-1, -2, -3, -4, -5, -6},
                {-7, -8, -9, -10, -11, -12}})));
        System.out.println("// HW 5 - принимаем 2д массив и сортируем значения в его строках = " + Arrays.deepToString(sortArray(new int[][]{
                {-55, 15, -5, 0, 999, 5, 112,},
                {1, 5, -278, -90, 100},
                {4, 52, -78, -85, -8, 12, -77},
                {-55, 123, -4578, 3, 7}})));

        System.out.println("// 1) ф-я принимает массив и инт число - номер строки и возвращает среднее элементов на этой строке = " + averageInRow(new int[][]{
                {-55, 15, -5, 0, 999, 5, 112,},
                {1, 5, -278, -90, 100},
                {4, 52, -78, -85, -8, 12, -77},
                {-55, 123, -4578, 3, 7}}, 1));
        System.out.println("// 2)ф-я принимает прямоуг массив и инт - номер столбца и возвращает сумму элементов в этом столбце = "
                + sumElementsInColumn(new int[][]{
                {99, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {-1, -2, -3, -4, -5, -6},
                {-7, -8, 9, -10, -11, -12}}, 2));

        String winner = whoWin(new int[][]{{1, 99, 5, 7, 0}, {7, 8, 10, 12}, {77, 88, 10, 12, 99}, {0, 1, 4, 99}, {8, 0, 0}}, new String[]{"Vasya", "Petro", "Niko", "Ksenia", "Leon"});
        System.out.println(winner);

        int sumEdgeOfArray = sumEdgeOfArray(new int[][]{
                {1, 99, 5, 7, 0},
                {7, 8, 10, 12, 12},
                {77, 88, 10, 12, 99},
                {0, 1, 4, 99, 5},
                {8, 0, 0, 45, 1}});
        System.out.println("//1) принимаем массив интов 2д и возвращаем сумму єлементов с краев = " + sumEdgeOfArray);

        changeElementsInColumns(new int[][]{
                {99, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {-1, -2, -3, -4, -5, -6},
                {-7, -8, 9, -10, -11, -12}}, 2, 4);

        changeElementsInRows(new int[][]{
                {99, 2, 3, 4, 5, 6, 7, 77, 9},
                {7, 8, 9, 10},
                {-1, -2, -3, -5, -6},
                {-7, -8, 9, -10, -11, -12}}, 0, 3);

        printEveryElements(new int[]{3, 1, 2, 3, 2, 2, 4, 1, 0, 9, 3, 0});

        boolean checkIfSimilar = checkIfSimilar(new int[]{3, 1, 2, 3, 2, 2, 4}, new int[]{3, 2, 2, 4, 9});
        System.out.println(checkIfSimilar);

        sortArrayFromMaxToMin(new int[][]{
                {99, 2, 3, 4, 5, 6, 7, 77, 9},
                {7, 8, 9, 10},
                {-1, -2, -3, -5, -6},
                {-7, -8, 9, -10, -11, -12}});
        sortColumnFromMinToMax(new int[][]{
                {-1, 8, 0, 4, 9, -8},
                {2, 3, -1, 7, 3, 7},
                {9, 7, 5, -66, 10, -5},
                {4, -12, 15, 1, 3, 25}});


        char[][] arr = fillArray(4, 6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();

        boolean checkifSymmetric = checkifSymmetric(new int[][]{
                {0, 2, 5, 8},
                {2, 1, 6, 7},
                {5, 6, 3, 4},
                {8, 7, 4, 9}});
        System.out.println(checkifSymmetric);

    }

    //бублик
    public static void printBooblyk(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i == 0 || i == array.length - 1) || (j == 0 || j == array[i].length - 1)) {
                    System.out.print(array[i][j] + "  ");
                } else System.out.print("    ");
            }
            System.out.println();
        }
    }

    //напечатать триугольником
    public static void printTriangle(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i >= j) {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //ф-я принимает прямоуг 2д массив и печатает сердцевину
    public static void printMiddleArray(int[][] array) {
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //ф-я принимает массив 2д а возвращает 1д массив с элементов этого 2д
    public static int[] array1DFrom2D(int[][] arrayBase) {
        int arrayLength = 0;

        for (int i = 0; i < arrayBase.length; i++) {
            arrayLength = arrayLength + arrayBase[i].length;
        }
        int[] arrayNew = new int[arrayLength];
        for (int i = 0, buffer = 0; i < arrayBase.length; i++) {
            for (int j = 0; j < arrayBase[i].length; j++) {
                arrayNew[buffer++] = arrayBase[i][j];
            }
        }
        return arrayNew;
    }

    //HW 1 - принимаем 2д массив и возвращаем 1д с только положительными элементами переданного 2д
    public static int[] checkOnlyPositive(int[][] array) {
        int lenght = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    lenght++;
                }
            }
        }
        int[] arrayPositive = new int[lenght];
        for (int i = 0, k = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    arrayPositive[k++] = array[i][j];
                }
            }
        }
        System.out.println("исходный 2d массив = " + Arrays.deepToString(array));
        return arrayPositive;
    }

    //HW 2 - принимаем 2д массив и возвращаем среднее его положительных элементов в нечетных строках
    public static double averagePositiveOddLine(int[][] array) {
        int length = 0;
        double sum = 0;
        int counter = 0;
        double average = 0;
        for (int i = 1; i < array.length; i = i + 2) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum = sum + array[i][j];
                    counter++;
                }
            }
        }
        average = sum / counter;
        average = Math.round(average * 100.0) / 100.0;

        return average;
    }


    //ф-я принимает 2д массив и рандомно смешивает его элементы
    public static void cardArray(int[][] array) {
        Random generator = new Random();

        int buffer = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int a = generator.nextInt(array.length);
                int b = generator.nextInt(array[a].length);
                buffer = array[i][j];
                array[i][j] = array[a][b];
                array[a][b] = buffer;

            }
        }
        System.out.println(Arrays.deepToString(array));
    }

    //ф-я принимает 2 инта и возвращает массив 2д с такими размерами. заполненный только случ нечетными отрицат числами с диапазона от -12 до 15
    public static int[][] matrix(int one, int two) {
        int[][] arr = new int[one][two];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Random generator = new Random();
                int a = generator.nextInt(-12, 16);
                if (a % 2 == -1) {
                    arr[i][j] = a;
                }
            }
        }
        return arr;
    }

    // HW 3 - ф-я принимает 2д массив и возврашает среднее значений на четных строках
    public static double averagePositiveEvenLine(int[][] array) {
        double sum = 0;
        int counter = 0;
        double average = 0;
        for (int i = 0; i < array.length; i = i + 2) {
            for (int j = 0; j < array[i].length; j++) {
                sum = sum + array[i][j];
                counter++;
            }
        }
        average = sum / counter;
        average = Math.round(average * 100.0) / 100.0;
        System.out.println(Arrays.deepToString(array));
        return average;
    }

    // HW 4 - ф-я принимает прямоугольный 2д массив и создает его точную копию и возвращает эту копию
    public static int[][] copy2DArray(int[][] array) {
        int[][] copyArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                copyArray[i][j] = array[i][j];
            }
        }
        return copyArray;
    }

    // HW 5 - принимаем 2д массив и сортируем значения в его строках
    public static int[][] sortArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            Arrays.sort(array[i]);
        }
        return array;
    }

    //1) ф-я принимает массив и инт число - номер строки и возвращает среднее элементов на этой строке

    public static double averageInRow(int[][] array, int num) {
        int sum = 0;
        double average = 0;
        for (int j = 0; j < array[num].length; j++) {
            sum = sum + array[num][j];
        }
        average = sum * 1.0 / array[num].length;
        average = Math.round(average * 100.0) / 100.0;
        return average;
    }

//2)ф-я принимает прямоуг массив и инт - номер столбца и возвращает сумму элементов в этом столбце

    public static int sumElementsInColumn(int[][] array, int column) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i][column];
        }
        return sum;
    }

    //ф-я приним 2д массив с рез-тами участников и 1д типа стринг с именами участников/ Возвратить имя победителя
// (у кого наибольший бал и если таких несколько - того у кого сумма результатов наибольшая
    public static String whoWin(int[][] gameResults, String[] names) {

        int indexWinner = 0; // победитель
        int maxWinner = gameResults[0][0]; // результат победителя в строке
        int maxCurrent = gameResults[0][0]; // результат претендента
        int sumWinner = 0; // общая сумма результатов победителя
        int sumCurrent = 0;// общая сумма результатов претендента
        for (int i = 0; i < gameResults.length; i++) {
            for (int j = 0; j < gameResults[i].length; j++) {
                if (gameResults[i][j] > maxCurrent) {
                    maxCurrent = gameResults[i][j];
                }
                sumCurrent = sumCurrent + gameResults[i][j];
            }

            if (maxCurrent > maxWinner) {
                maxWinner = maxCurrent;
                sumWinner = sumCurrent;
                indexWinner = i;
            } else if (maxWinner == maxCurrent && sumCurrent > sumWinner) {
                maxWinner = maxCurrent;
                sumWinner = sumCurrent;
                indexWinner = i;
            }
            sumCurrent = 0;
            maxCurrent = 0;
        }
        return names[indexWinner];

//        int indexFirstMax = 0;
//        int indexSecondMax = 0;
//        int resultFirstMaxInRow = gameResults[0][0];
//        int resultSecondMaxInRow = gameResults[0][0];
//        int sumInRowIndexFirst = 0;
//        int sumInRowIndexSecond = 0;
//        int indexWinner = 0;
//
//        for (int i = 0; i < gameResults.length; i++) {
//            for (int j = 0; j < gameResults[i].length; j++) {
//                if (gameResults[i][j] > resultFirstMaxInRow) {
//                    resultSecondMaxInRow = resultFirstMaxInRow;
//                    indexSecondMax = indexFirstMax;
//                    resultFirstMaxInRow = gameResults[i][j];
//                    indexFirstMax = i;
//                } else if ((resultFirstMaxInRow >= gameResults[i][j]) && (gameResults[i][j] > resultSecondMaxInRow)) {
//                    resultSecondMaxInRow = gameResults[i][j];
//                    indexSecondMax = i;
//                }
//            }
//        }
//        if (resultFirstMaxInRow == resultSecondMaxInRow) {
//            for (int j = 0; j < gameResults[indexFirstMax].length; j++) {
//                sumInRowIndexFirst = sumInRowIndexFirst + gameResults[indexFirstMax][j];
//            }
//            for (int j = 0; j < gameResults[indexSecondMax].length; j++) {
//                sumInRowIndexSecond = sumInRowIndexSecond + gameResults[indexSecondMax][j];
//            }
//            if (sumInRowIndexFirst > sumInRowIndexSecond) {
//                indexWinner = indexFirstMax;
//            } else indexWinner = indexSecondMax;
//
//        } else indexWinner = indexFirstMax;
//        return names[indexWinner];
    }

    //1) принимаем массив интов 2д и возвращаем сумму єлементов с краев
    public static int sumEdgeOfArray(int[][] array) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0 || j == array[i].length - 1) {
                    sum1 = sum1 + array[i][j];
                }
                if (i == 0 || i == array.length - 1) {
                    sum2 = sum2 + array[i][j];
                }
            }
        }
        sum3 = sum1 + sum2;
        return sum3;
    }

    //2) принимаем прямоуг 2д массив и 2 инта - номера столбцов для обмена значениями
    public static void changeElementsInColumns(int[][] array, int column1, int column2) {

        System.out.println("//2) принимаем прямоуг 2д массив и 2 инта - номера столбцов для обмена значениями ");
        int buffer = 0;
        for (int i = 0; i < array.length; i++) {
            buffer = array[i][column1];
            array[i][column1] = array[i][column2];
            array[i][column2] = buffer;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }

    // 3) принимаем массив 2д и 2 инта - номера строк для обмена значениями
    public static void changeElementsInRows(int[][] array, int row1, int row2) {
        System.out.println("// 3) принимаем массив 2д и 2 инта - номера строк для обмена значениями ");

        int[] buffer = new int[0];
        buffer = array[row1];
        array[row1] = array[row2];
        array[row2] = buffer;

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();

    }

    //Доделать ---------  4) ф-я принимает массив интов и печатает количество каждого элемента в нем
    public static void printEveryElements(int[] array) {
        System.out.println(Arrays.toString(array));
        int counter = 1;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < i; k++) {
                if (array[i] != array[k]) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[i] == array[j]) {
                            counter++;
                        }
                    }
                    System.out.println("amount of elements " + array[i] + " equal = " + counter);
                }
            }
        }
        counter = 1;
    }

    //принимаем 2 массива и возвращаем тру, если все элементы второго есть в первом
    public static boolean checkIfSimilar(int[] arr1, int[] arr2) {
        vasya:
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j])
                    continue vasya;
            }
            return false;
        }
        return true;
    }

    // Доделать ---------  принимаем 2 массива и возвращаем тру, если все элементы второго есть в первом - тоже самое, но последовательность цифр имеет значение.


    //принимаем 2д массив и сортируем его по убыванию
    public static void sortArrayFromMaxToMin(int[][] array) {
        System.out.println("принимаем 2д массив и сортируем его по убыванию");
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            counter = counter + array[i].length;
        }
        int[] buffer = new int[counter];
        for (int i = 0, k = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                buffer[k++] = array[i][j];
            }
        }
        Arrays.sort(buffer);
        System.out.println(Arrays.toString(buffer));

        for (int i = 0, k = buffer.length - 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = buffer[k--];
            }
        }
        System.out.println(Arrays.deepToString(array));
    }

    //Доделать домашка  ---------  ф-я принимает массив 2д прямоугольный и сортирует его столбцы
    public static void sortColumnFromMinToMax(int[][] array) {
        System.out.println("ф-я принимает массив 2д прямоугольный и сортирует его столбцы");

        for (int j = 0; j < array[0].length; j++) {
            int[] buffer = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                buffer[i] = array[i][j];
            }
            System.out.println(Arrays.toString(buffer));
            Arrays.sort(buffer);
            System.out.println("Отсортированный столбец  = " + Arrays.toString(buffer));

            for (int i = 0; i < array.length; i++) {
                array[i][j] = buffer[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("Отсортированный 2д массив = " + Arrays.toString(array[i]));
        }
    }
    //принимаем 2 инта - размер прямоугольного 2д массива и возвращаем 2д массив заполненный Х как на рисунке
    public static char[][] fillArray(int a, int b) {
        char[][] array = new char[a][b];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    array[i][j] = 'x';
                }
            }
        }
        return array;
    }

    //ф-я принимаем квадратный массив и возвращает тру, если его элементы симметричны над и под диагональю
    public static boolean checkifSymmetric(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != array[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
// ф-я принимает 2д массив квадратный и возврашает тру если он симметричен относительно диагонали



}









