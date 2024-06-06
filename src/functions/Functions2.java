package functions;

import java.util.Arrays;

public class Functions2 {
    public static void main(String[] args) {
        int result = sum(3, 7);
        System.out.println("sum = " + (result + 6));
        double num = average(5, 4);
        System.out.println("num = " + num);
        double average = averagePositive(new int[]{-56, 12, 5, 6, 7, 8, 9, -45, 4, 8, 10, 11});
        System.out.println("возвращает среднее положительных с конца массива до первого отрицательного = " + average);
        int[] numberOfElementsInArray = returnBiggerNumbers(new int[]{2, 4, 5, 6, 99}, new int[]{10, 20, 30});
        System.out.println("1) ф-я принимает 2 массивы и возвращает тот, у кого количество элементов больше = " + Arrays.toString(numberOfElementsInArray));

        int index = meetIndex(new int[]{2, 4, 5, 3, 6, 99}, 3);
        System.out.println(index);
        int index1 = findLastChar(new char[]{'%', 'b', 'c', 'd', ')', '*'}, '%');
        System.out.println("Индекс ячейки чар = " + index1);
        boolean check = check(new int[]{12, 5, 6, 7, 8});
        System.out.println("negative or positive = " + check);
        System.out.println("1)ф-я принимает массив чаров и возвращает тру если там нет символов цифр = "
                + checkNumber(new char[]{'/', '%', 'b', 'c', 'd', ')', '*', '@', '*'}));
        System.out.println("2)ф-я принимает массив интов и возвращает тру если там не больше 2-х нечетных чисел = "
                + checkNegative1(new int[]{-56, 12, 32, 5, 6, 7, 8, 9, 45, 4, 8, 10, 11}));
        System.out.println("3)ф-я принимает инт и возвращает произведение всех чисел от этого числа до 0 = "
                + myltiplyNumber(9));
        //System.out.println(Arrays.toString(createArray(-2, -14)));
        System.out.println(symetricArray(new int[]{5, 6, 7, 8, 9, 7, 8, 7, 6, 5}));
        System.out.println(checkIfSimple(70));
        printSimpleMyltiply(18);

        System.out.println("1) ф-я принимает массив интов и возвращает тру если там не больше 2-з отрицательных чисел = "
                + checkNegative(new int[]{5, 6, -7, -8, 9, 7, 8, 7, 6, 5, -1}));
        System.out.println("2) ф-я принимает массив интов и возвращает сразу второй максимум и второй минимум с него = "
                + Arrays.toString(checkMinMaxNumber(new int[]{-56, 12, 32, 5, 7, 8, 9, 45, 4, 8, -99, 11, -99, 201})));
        System.out.println(amountNumber(0));
        System.out.println(largeNumber(789456250));
        System.out.println("принимаем целое число и возвращаем сумму его цифр = " + sumNumber(478945612));
        System.out.println("принимаем массив типа чар и возвращаем количество четных цифр с него = " +
                evenAmount(new char[]{'/', '%', '8', '5', 'd', '3', '*', '1', '*', '0', 'b', 'c', '0', '7', '*', '@', '4', '$', '^',}));
        System.out.println("принимаем массив чаров и возвращаем сумму нечетных цифр с него ="
                + sumNumber(new char[]{'1', '%', '8', '5', 'd', '?', '*', '6', '*', '%', 'b', 'c', 'd', ')', '*', '@', '4', '$', '^',}));

        System.out.println("//дз - найти второй максимум не используя сортировки = "
                + checkMaxNumber(new int[]{-56, 12, 32, 5, 7, 8, 9, 45, 4, 8, -99, 11, -99, 201, 785, 654, 123, 75}));

    }

    //
    public static int sum(int a, int b) {
        int res = a + b;
        return res;
    }
    //ф-я принимает 2 инта и возвращает среднее этих чисел

    public static double average(int a, int b) {
        double averageResult = (a + b) / 2.0;
        return averageResult;
    }

    //ф-я принимает инт массив и возвращает среднее положительных с конца массива до первого отрицательного
    public static double averagePositive(int[] num) {
        int sum = 0;
        int counter = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] >= 1) {
                sum = num[i] + sum;
                counter++;
            } else {
                break;
            }
        }
        double average = sum * 1.0 / counter;
        return average;
    }
    // 1)ф-я принимает 2 массивы и возвращает тот, у кого количество элементов больше

    public static int[] returnBiggerNumbers(int[] numb1, int[] numb2) {
        if (numb1.length > numb2.length) return numb1;
        else return numb2;
    }
    // 2)ф-яч принимает 2 инта и создает массив с элементами от первого до второго включительно, даже если эти элементы выставлены некорректно

//    public static int[] createArray(int num1, int num2) {
//
////        num1 < 0 && num2 < 0 // - 10 - 20 //  module + sum
////        num1 > 0 && num2 > 0 // 10 20 = minus
////        num1 < 0 && num2 > 0 //  - 10 20 = minus module
////        num1 > 0 && num2 < 0 // 20 - 10 =
////        x =
////
////        if(x > num1 && x < num2){
////
////        }
//        //        int n1 = Math.abs(num1);
////        int n2 = Math.abs(num2);
////        int[] dinamicArray = new int[n1 + n2];
////
////        for (int i = 0; i < dinamicArray.length; i++) {
////
////            if (n1 < n2) {
////                dinamicArray[i] = num1 + i;
////                break;
////            } else if (n2 < n1) dinamicArray[i] = num2 + i;
////        }
////        System.out.println(Arrays.toString(dinamicArray));
////        return dinamicArray;
//    }

    // ф-я принимает массив интов и еще один инт и возвращает номер ячейки, где этот инт встречается или -1
    // если такого инта нет в массиве

    public static int meetIndex(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
    //принимаем чаровский массив и еще один чар и возвращаем номер ячейки, в которой этот чар встречается в последний раз

    public static int findLastChar(char[] array, char symb) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == symb) return i;
        }
        return -1;
    }
    //ф-я принимает массив интов и возвращает тру, если там есть отрицательные и фолс - если их там нет

    public static boolean check(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) return true;
        }
        return false;
    }

    // 1)ф-я принимает массив чаров и возвращает тру если там нет символов цифр

    public static boolean checkNumber(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] > 47 && chars[i] < 58)) return true;
        }
        return false;
    }
    //2)ф-я принимает массив интов и возвращает тру если там не больше 2-х нечетных чисел

    public static boolean checkNegative1(int[] num) {
        int counter = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) counter++;
        }
        if (counter <= 2) return true;
        return false;
    }
    // 3)ф-я принимает инт и возвращает произведение всех чисел от этого числа до 0

    // Если в массиве отрицательные числа? если в ифе создать массив - цикл не видит его
//        if(num < 0){
//            int num1 = Math.abs(num);
//            int[]arrayNum1 = new int[num1];
//        } else {
//            int[]arrayNum1 = new int[num];
//        }
    public static int myltiplyNumber(int num) {
        int buffer = 1;
        int[] arrayNum = new int[num];
        for (int i = 0; i < num; i++) {
            arrayNum[i] = num - i;
        }
        for (int i = arrayNum.length - 1; i >= 0; i--) {
            buffer = arrayNum[i] * buffer;
        }
        return buffer;
    }
    //ф-я принимает массив и возвращает тру если он симметричен относительно центра

    public static boolean symetricArray(int[] num) {
        for (int i = 0, j = num.length - 1; i < num.length / 2; i++, j--) {
            if (num[i] != num[j]) return false;
        }
        return true;
    }

    //принимаем число типа инт и возвращаем тру если оно простое
    public static boolean checkIfSimple(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    //ф-я принимает целое число и печатает все его простые множители

    public static void printSimpleMyltiply(int num) {
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                boolean result = checkIfSimple(i);
                if (result) {
                    System.out.println(i + " ");
                }
            }
        }
    }
    //ф-я принимает массив типа чар и возвращает тру если там нет спецсимволов? а только буквы и цифры

    public static boolean check(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (!((chars[i] > 47 && chars[i] < 58) || (chars[i] > 64 && chars[i] < 91) || (chars[i] > 96 && chars[i] > 123))) {
                return false;
            }
        }
        return true;
    }

    //1) ф-я принимает массив интов и возвращает тру если там не больше 2-з отрицательных чисел
    public static boolean checkNegative(int[] num) {
        int counter = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) counter++;
        }
        if (counter <= 2) return true;
        return false;
    }

    // 2) ф-я принимает массив интов и возвращает сразу второй максимум и второй минимум с него

    public static int[] checkMinMaxNumber(int[] num) {
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        int max = num[num.length - 1];
        int min = num[0];
        int[] minMax = new int[2];
        for (int i = num.length - 2; i >= 0; i--) {
            if ((num[i] < max) && (num[i] != max)) {
                minMax[1] = num[i];
                break;
            }
            for (int j = 1; j < num.length; j++) {
                if ((num[j] > min) && (num[j] != min)) {
                    minMax[0] = num[j];
                    break;
                }
            }
        }
        return minMax;
    }
    //дз - найти второй максимум не используя сортировки

    public static int checkMaxNumber(int[] num) {
        int max = num[0];
        int max2 = num[0];

        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max2 = max;
                max = num[i];
            } else if (max >= num[i] && num[i] > max2) {
                max2 = num[i];
            }
        }
        return max2;
    }

    //ф-я принимает инт и возвращает количество цифр
    public static int amountNumber(int num) {
        int counter = 1;
        while (num / 10 != 0) {
            num = num / 10;
            counter++;
        }
        return counter;
    }

    //ф-я принимает инт число и возвращает наибольшую цифру с него
    public static int largeNumber(int num1) {
        int max = 1;
        while (num1 / 10 != 0) {
            int num2 = num1 % 10;
            if (num2 > max) {
                max = num2;
            }
            num1 = num1 / 10;
        }
        return max;
    }

    //принимаем целое число и возвращаем сумму его цифр
    public static int sumNumber(int num) {
        int sum = 0;
        while (num / 10 != 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }
        return sum + num;
    }


    //    принимаем массив типа чар и возвращаем количество четных цифр с него
    public static int evenAmount(char[] chars) {
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] > 48 && chars[i] < 58) && chars[i] % 2 == 0) {
                System.out.println(chars[i]);
                counter++;
            }
        }
        return counter;
    }

    //принимаем массив чаров и возвращаем сумму нечетных цифр с него
    public static int sumNumber(char[] chars2) {
        int sum = 0;
        for (int i = 0; i < chars2.length; i++) {
            if ((chars2[i] > 47 && chars2[i] < 58) && chars2[i] % 2 != 0) {
                System.out.println(chars2[i]);
                sum = sum + chars2[i] - 48;
            }
        }
        return sum;
    }
}


