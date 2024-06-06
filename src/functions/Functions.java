package functions;


import java.util.Arrays;
import java.util.Random;

public class Functions {

    public static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println("hello");
        }
    }

    //    public static void main(String[] args) {
//        System.out.println("before function");
//        print();
//        System.out.println("after function");
//        Functions.print();
//        System.out.println("finish");
//    }
    public static void print(int amount, String text) {
        for (int i = 0; i < amount; i++) {
            System.out.println(text);
        }
    }
    //ф-я принимает инт - размер и создает массив и заполняет его случайными буквами

    public static void createArray(int size) {
        Random generator = new Random();
        char[] array = new char[size];

        for (int i = 0; i < array.length; i++) {
            char a = (char) generator.nextInt('a', 'z' + 1);
            array[i] = a;
        }
        System.out.println(Arrays.toString(array));
    }
    //ф-я принимает инт и чар и печатает квадрат такими чарами размером этого инта

    public static void print(int num, char symbol) {
        Random generator = new Random();
        char[] chars = new char[num];
        for (int i = 0; i < num; i++) {
            chars[i] = symbol;
        }
        for (int i = 0; i < num; i++) {
            System.out.println(Arrays.toString(chars));
        }
    }

    //ф-я принимает 2 массива и склеивает их
    public static void glue(int[] num1, int[] num2) {
        int[] numbers = new int[num1.length + num2.length];
        System.arraycopy(num1, 0, numbers, 0, num1.length);
        System.arraycopy(num2, 0, numbers, numbers.length - num2.length, num2.length);
        System.out.println(Arrays.toString(numbers));
    }

    //1) ф-я принимает массив чаров и печатает тру если там есть цифры
    public static void print(char[] chars) {
        System.out.println("//1) ф-я принимает массив чаров и печатает тру если там есть цифры");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                System.out.println(true);
                break;
            }
        }
    }

    // 2( ф-я принимает массив чаров и печатает тру если там нет символов цифр
    public static void printTrue(char[] chars) {
        System.out.println("Домашка - // 2( ф-я принимает массив чаров и печатает тру если там нет символов цифр");
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] >= 32 && chars[i] <= 64) || (chars[i] >= 91 && chars[i] <= 96) || (chars[i] >= 123 && chars[i] <= 127)) {
                System.out.println(true);
                break;
            }
        }
    }

// 3)ф-я принимает чаровский массив и делает так, чтобы чередовались маленькие и большие буквы

    public static void list(char[] lists) {
        System.out.println("\"Домашка 1 - // 3)ф-я принимает чаровский массив и делает так, чтобы чередовались маленькие и большие буквы");
        int registerCounter = 0;
        for (int i = 0; i < lists.length; i++) {
            if ((lists[i] >= 65 && lists[i] <= 90) || (lists[i] >= 97 && lists[i] <= 122)) {
                registerCounter++;
            }
        }
        char[] letters = new char[registerCounter];
        for (int i = 0, j = 0; i < lists.length; i++) {
            if ((lists[i] >= 65 && lists[i] <= 90) || (lists[i] >= 97 && lists[i] <= 122)) {
                letters[j++] = lists[i];
            }
        }
        Arrays.sort(letters);
        //System.out.println(Arrays.toString(letters));
        for (int i = 0, j = letters.length - 1; j >= letters.length / 2; i = i + 2, j = j - 2) {
            char buffer = letters[j];
            letters[j] = letters[i];
            letters[i] = buffer;
        }
        System.out.println(Arrays.toString(letters));
    }
    //ф-я принимает 2 инта и чар и печатает прямоугольник состояший из такик чаров с высотой как первый инт и шириной как второй инт

    public static void fill(char chars, int size1, int size2) {
        System.out.println("//ф-я принимает 2 инта и чар и печатает прямоугольник состояший из такик чаров с высотой как первый инт и шириной как второй инт");
        for (int i = 0; i <= size1; i++) {
            for (int j = 0; j <= size2; j++) {
                System.out.print(chars + " ");
            }
            System.out.println();
        }
    }

    //ф-я принимает инт и чар печатает триугольник
    public static void fill(int size) {
        System.out.println("//ф-я принимает инт и чар печатает триугольник");
        for (int i = 0; i <= size; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //ф-я принимает инт и печатает все его множители
    public static void multiply(int number) {
        System.out.println("ф-я принимает инт и печатает все его множители");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    //Домашка 2 - ф-я принимает инт и печатает триугольник с числами
    public static void triangle(int size) {
        System.out.print("ф-я принимает инт и печатает триугольник с числами = ");
        for (int i = 0; i <= size; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //1) ф-я принимает массив  интов и удаляет все его отрицательные числа (с конца появится столько 0 , сколько отрицательных в нем)
    public static void deleteNegative(int[] nums) {
        System.out.println(" ф-я принимает массив  интов и удаляет все его отрицательные числа (с конца появится столько 0 , сколько отрицательных в нем");
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));

//   Через создание нового массива

//        int[] nums2 = new int[nums.length];
//        for (int i = nums2.length - 1, j = 0; i >= 0; i--, j++) {
//            nums2[j] = nums[i];
//        }

// В том же массиве
        for (int i = nums.length - 1, j = 0; i >= nums.length / 2; i--, j++) {
            int buffer = nums[j];
            nums[j] = nums[i];
            nums[i] = buffer;
        }
        System.out.println(Arrays.toString(nums));
    }

    //2)ф-я принимает 2 инта и чар и печатает бублик из этого чара с размером первого и второго инта

    public static void booblik(int size1, int size2, char symb) {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if((i > 0 && i < size1 - 1) && (j > 0 && j < size2 - 1)){
                    System.out.print("   ");
                } else {
                    System.out.print(symb + "  ");
                }
            }
            System.out.println("");
        }
    }
}
