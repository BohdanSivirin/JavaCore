package loops;

public class WhileLoop {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println("while");
            i = i + 1;
        }
        //напечатать числа от 3 до -18 в строку
        i = 3;
        while (i >= -18) {
            System.out.print(i + " ");
            i = i - 1;
        }
        System.out.println("____________________");
        // числа от -12 до 24 шаг 3/ Напечатать все что не попадает в диапазон от -7 до 12
        i = -12;
        while (i <= 24) {
            if (i < -7 || i > 12) {

                System.out.print(i + " ");
            }
            i = i + 3;
        }
        System.out.println("____________________");
        //от -15 до 34 шаг 2/ Напечатать все что не попадает в диапазоны от -10 до -3  и диапазон от 18 до 22
        i = -15;
        while (i <= 34) {
            if ((i < -10 || i > -3) && (i < 18 || i > 22)) {
                System.out.print(i + " ");
            }
            i = i + 1;
        }

        int cat = 3;
        while (cat > 0) {
            System.out.println("\nThere is too many cats");
            cat--;
        }

    }
}
