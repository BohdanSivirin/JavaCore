package loops;

public class ForLoop {
    public static void main(String[] args) {
        for (int i = 0, j = 6; i < 4; i = i + 1) {
            System.out.println("hello");
        }
        //напечатать в строку числа от -12 до 14 с шагом 2
        for (int i = -12; i <= 14; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        //напечатать в строку числа от 23 до -12 шаг 3
        for (int i = 23; i >= -12; i = i - 3) {
            System.out.print(i + " ");
        }
        System.out.println();
        //от -4 до -21 шаг 2
        for (int i = -4, a = -21; i >= a; i = i - 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        //числа от 35.5 до -21.25 шаг 3.12
        for (double i = 35.5; i >= -21.25; i = i - 3.12) {
            i = Math.round(i * 100.0) / 100.0;
            System.out.print(i + " ");
        }

        double a = 12.45759654123; //12.458
        System.out.println("\n" + Math.round(a * 1000.0) / 1000.0);
        a = Math.round(a * 1000.0) / 1000.0;
        System.out.println(a);


//        task 1
//        цикл от -21 до 13 шаг 1. Напечатать только числа -10  0 и 7

        for (int i = -21; i <= 13; i = i + 1) {
            if (i == -10 || i == 0 || i == 7) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //      цикл от 32 до  11 шаг 1 Напечатать все числа кроме чисел 21. 15 и 19

        for (int i = 32; i >= 11; i = i - 1) {
            if (i != 21 && i != 15 && i != 19) {
                System.out.print(i + " ");
            }
        }

//        цикл от 12 до 34 шаг 3/ Напечатать все что попало в диапазон от 21 до 29
        for (int i = 12; i <= 34; i = i + 3) {
            if (i >= 21 && i <= 29) {
                System.out.print("\n " + i + " ");
            }
        }


    }
}
