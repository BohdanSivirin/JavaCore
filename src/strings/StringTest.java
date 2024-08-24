package strings;

import java.util.Arrays;
import java.util.Random;

public class StringTest {
    public static void main(String[] args) {
        String text = " $%^hello world 1234";
        System.out.println(text);
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int sum = sumString(" $%^hello world 1234");
        System.out.println(sum);
        System.out.println(" ");

        boolean checkPassword = checkPassword(" $%^hello world qwerty@4#%*");
        System.out.println(checkPassword);
        System.out.println(" ");

        System.out.println("// 1)принимаем массив стрингов и печатаем стринги у которых есть цифры");
        printNumber(new String[]{"099949%*^&(J", "pretty well", "hello world", "$%^hello world qwerty@4#%*", "massive", "1234ventured"});
        System.out.println();
        System.out.println("// 2)принимаем массив стрингов и печатаем стринги у которых НЕТ цифр");
        printLetter(new String[]{"pretty %*^&(J", "pretty well0", "hello 12 world", "$%^hello world qwerty@4#%*", "massive", "1234ventured"});
        System.out.println("// 3)принимаем стринг и возвращаем наибольшую цифру с него\n");
        int checkTheBigNumber = checkTheBigNumber(" 123412548$%^hello world qwerty@4#%*++1234ventured");
        System.out.println(checkTheBigNumber);

        System.out.println("//ф-я принимает лонг и возвращает количество цифр в нем");
        int amountOfNumber = amountOfNumber(12341L);
        System.out.println(amountOfNumber);

        System.out.println("//принимаем дабл число и возвращаем сумму цифр после точки");
        int sumNumAfterPoint = sumNumAfterPoint(32.0623);
        System.out.println(sumNumAfterPoint);

        System.out.println("//ф-я принимает дабл и возвращает наибольшую цифру с него");
        int checkLargeNum = checkLargeNum(5372.0623);
        System.out.println(checkLargeNum);

        System.out.println("// 1)ф-я принимает массив интов и возвращает номер минимального по модулю элемента");
        int numOfElement = numOfElement(new int[]{-125, -3, 4, -5, 6, 7, -8, 9, 10, 11, -14, 15, 16, 17, 18, 19, 20, 21, 22, -2, 23, -24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38});
        System.out.println(numOfElement);

        System.out.println("// 2)ф-я принимает стринг и возвращает тру если в нем нет гласных букв");
        boolean checkVowels = checkVowels("wrld");
        System.out.println(checkVowels);

        System.out.println("// 3)принимаем массив интов и возвращаем сумму модулей чисел, расположенных после первого отрицательного");
        int sumModuleNumsAfterNegative = sumModuleNumsAfterNegative(new int[]{30, 31, 32, 33, 34, 35, -100, 6, 4, 10, -5, -2});
        System.out.println(sumModuleNumsAfterNegative);

        System.out.println("//принимаем стринг и возвращаем стринг зеркальный передаваемому");
        String textAbove = textAbove("Vasya");
        System.out.println(textAbove);

        System.out.println("// ф-я принимает текст и возвращает стринг у которого сначала гласные потом цифры а потом согласные");
        String randomText = randomText("VasyaVasyaVasyaVasyaVasya132456!@$&(^)(__gjsdfoyu");
        System.out.println(randomText);

        System.out.println();
        System.out.println("//ф-я принимает инт число и еще одну цифру и возвращает количество таких цифр в числах от 0 до передаваемого инта");
        int amountOfSecondNumInFirst = amountOfSecondNumInFirst(40, 3);
        System.out.println(amountOfSecondNumInFirst);

        System.out.println();
        System.out.println("// 1) принимаем стринг и все его цифры увеличиваем в 3 раза и возвращаем стринг");
        String multiplyNumsInText = multiplyNumsInText("VasyaVasyaVasyaVasyaVasya132456!@$&(^)(__gjsdfoyu");
        System.out.println(multiplyNumsInText);

        System.out.println();
        System.out.println("// 2)принимаем стринг ---- done\n" +
                "    // и инт - максимальное\n" +
                "    // количество цифр в стр\n" +
                "    // оке и печатаем получе\n" +
                "    // нный текст");
        printText("VasyaVasya132456!@$&(^)(__gjsdfoyu1,5,6,8,9,71025@@_{RL132456", 11);

        System.out.println();
        System.out.println("// 3)ф-я принимает массив стрингов и все его стринги разворачиваем зеркально");
        turnText(new String[]{"массив", "стрингов", "разворачиваем", "зеркально", "Vasya"});

        System.out.println();
        System.out.println("//ф-я принимает стринг и убирает все пробелы по краям и возвращает стринг");
        String removeSpace = removeSpace("       Ab8d k9     ");
        System.out.println(removeSpace);
        System.out.println();
        System.out.println("// принимаем стринг и убираем все пробелі с краев и лишние в середине");
        removeSpace2("   gj sd  foy u1,5,  6 & 8,9,71025@    @ Ab8d k9 _{RL1324 (     *  ) >   при  ни  ма       ем      %    $      ");
        System.out.println();
        System.out.println("// ф-я принимает стринг и возвращает тру если все его буквы выстроены по алфавиту или фолс, если нет");
        boolean checkIfAlfabet = checkIfAlfabet("a132b456!@$c&(^)(_d_& W (y,5,6,8,9,Z");
        System.out.println(checkIfAlfabet);
        System.out.println();
        System.out.println("//ф-я принимает стринг и возвращает стринг без повторов символов");
        String checkIfSimilar = checkIfSimilar("a132b456!@$c&(^)(_d_& W (y,!@$565");
        System.out.println(checkIfSimilar);
        System.out.println();
        System.out.println("// принимаем инт и пока число не односложное - добиваемся его односложности путем суммирования цифр/\n" +
                "// Когда получается односложное - возвращаем тру если оно четное");
        boolean checkIfNumberIsEven = checkIfNumberIsEven(616);
        System.out.println(checkIfNumberIsEven);
        System.out.println();
        System.out.println("//ф-я принимает стринг и возвращает стринг, в котором все цифры остаются на своих местах,\n" +
                "    // а другие символы зеркально отображены относительно центра");
        returnTextWithSameNums("3ab49!t7?mZB9");
        System.out.println();
        System.out.println("//ф-я принимает инт и возвращает тру? если оно является числом армстронга");
        boolean checkIfTheArmstrongsNums = checkIfTheArmstrongsNums(1635);
        System.out.println(checkIfTheArmstrongsNums);
        System.out.println();
        textChess(new String[]{"2k_aCdt8", "km&*CY90!", "vhs%^123d_G", "123$Hm*k90@",});
        System.out.println();
        System.out.println("    //2)сгенерить рандомній пароль состоящий из 4 гласніх 3 согласніх и 5 цифр");
        createRandomPassword();
        System.out.println();
        char returnMaxAmountSymbol = returnMaxAmountSymbol("as2$3d05$678$33$s");
        System.out.println(returnMaxAmountSymbol);
        System.out.println();

        System.out.println(" //принимаем инт и возвращаем кол-во шагов для превращения этого числа в симметричное относительно центра число\n ");
        int startnum = 457;
        int reverseInt = reverseInt(startnum);
        System.out.println(" // развернуть число зеркально " + reverseInt);
        boolean isMirror = isMirror(reverseInt);
        System.out.println(" // является ли число зеркальным " + isMirror);
        int getAmountStepsToMirror = getAmountStepsToMirror(startnum);
        System.out.println(" // кол-во шагов до получения зеркального состояния " + getAmountStepsToMirror);
        System.out.println();
        System.out.println(" //ф-я принимает стринг и чар и возвращает массив стрингов, полученный разбиением стринга на набор стрингов чаром, что передается");
        String[] textArrayWithChar = t("принимает стринг и чар и возвращает массив array", ' ');
        System.out.println(Arrays.toString(textArrayWithChar));
        System.out.println();
        System.out.println("Home work 1 // ф-я принимает стринг и возвращает стринг, в котором максимальная и минимальная цмфры поменяны местами");
        String result = getMinMaxNums("hel9lo781wor0*ld$%4562");
        System.out.println(" максимальная и минимальная цмфры поменяны местами = " + result);
        System.out.println();
        System.out.println("Home work 2 // принимаем стринг и возвращаем максимальное количество подряд идущих цифр");
        int currentCounter = getAmountNumbs("+wor0*ld12$%457=pr5_&%758888");
        System.out.println("currentCounter = " + currentCounter);

    }

    // ф-я принимает стринг и возвращает сумму его цифр
    public static int sumString(String text) {
        char[] arr = text.toCharArray();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (arr[i] > '0' && arr[i] <= '9') {
                sum = sum + arr[i] - 48;
            }
        }
        return sum;
    }

    //принимаем стринг (пароль) и проверяем чтобы в нем не было цифр (если нет - возвращаем тру)
    public static boolean checkPassword(String password) {
        char[] arr = password.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > '0' && arr[i] <= '9') {
                return false;
            }
        }
        return true;
    }

    // 1)принимаем массив стрингов и печатаем стринги у которых есть цифры
    public static void printNumber(String[] text) {
        for (int i = 0; i < text.length; i++) {
            char[] arr = text[i].toCharArray();
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] > '0' && arr[k] <= '9') {
                    System.out.println(text[i]);
                    break;
                }
            }
        }
    }

    // 2) принимаем массив стрингов и печатаем стринги у которых НЕТ цифр - done
    public static void printLetter(String[] text) {
        for (int i = 0; i < text.length; i++) {
            char[] arr = text[i].toCharArray();
            for (int k = 0; k < arr.length; k++) {
                if ((arr[k] >= 48) && (arr[k] < 58)) {
                    break;
                }
                if (k == arr.length - 1) {
                    System.out.println(text[i]);
                }
            }
        }
    }
    // 3)принимаем стринг и возвращаем наибольшую цифру с него - done

    public static int checkTheBigNumber(String num) {
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        for (int i = arr.length - 1, max = 0; i > 0; i--) {
            if ((arr[i] >= '0' && arr[i] <= '9')) {

                return arr[i] - 48;
            }
        }

//        int max = 0;
//        int counter = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > '0' && arr[i] <= '9') {
//                counter++;
//            }
//        }
//        char[] arrNums = new char[counter];
//        for (int i = 0, k = 0; i < arr.length; i++) {
//            if (arr[i] > '0' && arr[i] <= '9') {
//                arrNums[k++] = arr[i];
//            }
//        }
//        for (int i = 0; i < arrNums.length; i++) {
//            if (arrNums[i] > max) {
//                max = arrNums[i];
//            }
//        }
        return -1;
    }

    //ф-я принимает лонг и возвращает количество цифр в нем
    public static int amountOfNumber(long num) {
        String text = "" + num;
        char[] arr = text.toCharArray();
        return arr.length;
    }

    //принимаем дабл число и возвращаем сумму цифр после точки
    public static int sumNumAfterPoint(double num) {
        int sum = 0;
        String text = "" + num;
        char[] arr = text.toCharArray();
        for (int i = arr.length - 1; i > 0 && arr[i] != '.'; sum += arr[i] - 48, i--) ;

        return sum;
    }

    //ф-я принимает дабл и возвращает наибольшую цифру с него
    public static int checkLargeNum(double num) {
        String text = "" + num;
        char[] arr = text.toCharArray();
        int max = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max - 48;
    }

    //ф-я принимает инт число и еще одну цифру и возвращает количество таких цифр в числах от 0 до передаваемого инта.

    public static int amountOfSecondNumInFirst(int num1, int num2) {
        int counter = 0;
        String a = "";
        for (int i = 0; i < num1; i++) {
            a = a + i;
        }
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == num2 + 48) {
                counter++;
            }
        }
        System.out.println(Arrays.toString(chars));
        return counter;
    }

    // 1)ф-я принимает массив интов и возвращает номер минимального по модулю элемента - done
    static public int numOfElement(int[] arr) {

        int min = Math.abs(arr[0]);
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) < min) {
                min = Math.abs(arr[i]);
                minIndex = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(min);
        return minIndex;
    }

    // 2)ф-я принимает стринг и возвращает тру если в нем нет гласных букв - done
    public static boolean checkVowels(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'A' || arr[i] == 'e' || arr[i] == 'E' ||
                    arr[i] == 'y' || arr[i] == 'Y' || arr[i] == 'u' || arr[i] == 'U' ||
                    arr[i] == 'i' || arr[i] == 'I' || arr[i] == 'o' || arr[i] == 'O') {
                return false;
            }
        }
        return true;
    }

    // 3)принимаем массив интов и возвращаем сумму модулей чисел, расположенных после первого отрицательного - done
    public static int sumModuleNumsAfterNegative(int[] nums) {
        int k = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                k = i;
                break;
            }
        }
        for (int i = k + 1; i < nums.length; i++) {
            sum = sum + Math.abs(nums[i]);
        }
        return sum;
    }

    //принимаем стринг и возвращаем стринг зеркальный передаваемому
    public static String textAbove(String text) {
        char[] arrText = text.toCharArray();
        String text1 = "";
        for (int i = arrText.length - 1; i >= 0; i--) {
            text1 = text1 + arrText[i];
        }
        return text1;
    }

    // ф-я принимает текст и возвращает стринг у которого сначала гласные потом цифры а потом согласные
    public static String randomText(String text) {
        char[] arr = text.toCharArray();
        String vowels = "";
        String nums = "";
        String consonants = "";
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {
                if (arr[i] == 'a' || arr[i] == 'A' || arr[i] == 'e' || arr[i] == 'E' ||
                        arr[i] == 'y' || arr[i] == 'Y' || arr[i] == 'u' || arr[i] == 'U' ||
                        arr[i] == 'i' || arr[i] == 'I' || arr[i] == 'o' || arr[i] == 'O') {
                    vowels = vowels + arr[i];
                } else consonants = consonants + arr[i];
            }
            if (arr[i] >= 48 && arr[i] <= 57) {
                nums = nums + arr[i];
            }
        }
        vowels = vowels + nums + consonants;
        return vowels;
    }

    // 1) принимаем стринг и все его цифры увеличиваем в 3 раза и возвращаем стринг
    public static String multiplyNumsInText(String text) {
        String textLow = text.toUpperCase();
        char[] arr2 = textLow.toCharArray();
        System.out.println(Arrays.toString(arr2));

        char[] arr = text.toCharArray();
        String text2 = "";
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] >= 48) && (arr[i] <= 57)) {
                text2 = text2 + ((arr[i] - 48) * 3);
            } else text2 = text2 + arr[i];
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return text2;

    }
    // 2)принимаем стринг ---- done
    // и инт - максимальное
    // количество цифр в стр
    // оке и печатаем получе
    // нный текст

    public static void printText(String text, int amountOfNums) {
        char[] arr = text.toCharArray();
        System.out.println(Arrays.toString(arr));
        String text2 = "";
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (j != amountOfNums) {
                text2 = text2 + arr[i];
                j++;
            } else if (j == amountOfNums) {
                System.out.println(text2);
                j = 0;
                i--;
                text2 = "";
            }
            if (i == arr.length - 1) System.out.println(text2);
        }
    }

    // 3)ф-я принимает массив стрингов и все его стринги разворачиваем зеркально
    public static void turnText(String[] text) {
        System.out.println(Arrays.toString(text));
        for (int i = 0; i < text.length; i++) {
            String text2 = "";
            char[] arr = text[i].toCharArray();
            for (int j = arr.length - 1; j >= 0; j--) {
                text2 = text2 + arr[j];
            }
            text[i] = text2;
        }
        System.out.println(Arrays.toString(text));
    }

    //ф-я принимает стринг и убирает все пробелы по краям и возвращает стринг
    public static String removeSpace(String text) {
        int counter = 0;
        int counter2 = 0;
        String text2 = "";
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                counter = i;
                break;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != ' ') {
                counter2 = i;
                break;
            }
        }
        for (int i = counter; i <= counter2; i++) {
            text2 = text2 + arr[i];
        }
        return text2;
    }

    // принимаем стринг и убираем все пробелі с краев и лишние в середине - done
    public static void removeSpace2(String t) {
        String s = removeSpace(t);
        System.out.println(s);
        char[] arr = s.toCharArray();
        boolean ifSpaceAlreadyMoved = false;
        String t2 = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                t2 = t2 + arr[i];
                ifSpaceAlreadyMoved = false;
            }
            if (arr[i] == ' ' && !ifSpaceAlreadyMoved) {
                t2 = t2 + arr[i];
                ifSpaceAlreadyMoved = true;
            }
        }
        System.out.println(t2);
    }

    // ф-я принимает стринг и возвращает тру если все его буквы выстроены по алфавиту или фолс, если нет
    public static boolean checkIfAlfabet(String text) {
        String text3 = "";
        String text2 = text.toLowerCase();
        char[] arr = text2.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                text3 = text3 + arr[i];
            }
        }
        char[] arr2 = text3.toCharArray();
        System.out.println(Arrays.toString(arr2));

        for (int i = 0, j = i + 1; i < arr2.length - 2; i++, j++) {
            if (arr2[j] < arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //ф-я принимает стринг и возвращает стринг без повторов символов
    public static String checkIfSimilar(String text) {
        System.out.println(text);
        String newText = "";
        char[] arr = text.toCharArray();

        go:
        for (int i = 0; i < arr.length; i++) {
            char[] newArr = newText.toCharArray();

            for (int j = 0; j < newArr.length; j++) {
                if (newArr[j] == arr[i]) {
                    continue go;
                }
            }
            newText = newText + arr[i];
        }
        return newText;
    }
    // принимаем инт и пока число не односложное - добиваемся его односложности путем суммирования цифр/
    // Когда получается односложное - возвращаем тру если оно четное

    public static boolean checkIfNumberIsEven(int num) {
        if (num >= 0 && num <= 9) {
            return num % 2 == 0;
        }

        int sum = 0;
        String text = "";
        text = text + num;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum == sum % 2) {
            return true;
        }
        return false;
    }
    //ф-я принимает стринг и возвращает стринг, в котором все цифры остаются на своих местах,
    // а другие символы зеркально отображены относительно центра

    public static void returnTextWithSameNums(String text) {
        char[] arr = text.toCharArray();

        char[] arrNums = new char[arr.length];
        String arrSymbols = "";
        for (int i = 0; i < arr.length; i++) {
            arrNums[i] = ' ';
            if (arr[i] >= '0' && arr[i] <= '9') {
                arrNums[i] = arr[i];
            } else {
                arrSymbols = arrSymbols + arr[i];
            }
        }
//        for (int i = 0; i < arrNums.length; i++) {
//
//        }

        char[] symbols = arrSymbols.toCharArray();
        System.out.println(Arrays.toString(symbols));

        for (int i = 0, j = symbols.length - 1; i < arrNums.length; i++) {
            if (arrNums[i] == ' ') {
                arrNums[i] = symbols[j--];
            }
        }
        System.out.println(Arrays.toString(arrNums));

    }

    //ф-я принимает инт и возвращает тру? если оно является числом армстронга
    public static boolean checkIfTheArmstrongsNums(int num) {
        int sum = 0;
        int allSum = 0;
        String text = "";
        text = text + num;
        char[] arr = text.toCharArray();
        for (int i = 0; i <= arr.length - 1; i++) {
            sum = (int) Math.pow((arr[i] - 48), arr.length);
            allSum = allSum + sum;
        }
//        System.out.println(num);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(sum);
//        System.out.println(allSum);
        return allSum == num;
    }

    public static void textChess(String[] text) {
        System.out.println(Arrays.toString(text));
        String text2 = "";
        for (int i = 0; i < text.length; i++) {
            char[] allCharacter = text[i].toLowerCase().toCharArray();
            char[] onlyText = new char[allCharacter.length];
            for (int j = 0, k = 0; j < allCharacter.length; j++) {
                if (allCharacter[j] >= 'a' && allCharacter[j] <= 'z') {
                    onlyText[k++] = allCharacter[j];
                    allCharacter[j] = ' ';
                }
            }
            for (int e = 0, r = 0; e < onlyText.length - 1; e = e + 2, r++) {
                text2 = (text2 + onlyText[e]).toUpperCase();
                char[] textWithBigLetter = text2.toCharArray();
                onlyText[e] = textWithBigLetter[r];
            }
//            System.out.println(Arrays.toString(onlyText));
            for (int y = 0, u = 0; y < allCharacter.length; y++) {
                if (allCharacter[y] == ' ') {
                    allCharacter[y] = onlyText[u++];
                }
            }
            System.out.println(Arrays.toString(allCharacter));
        }
    }

    //2)сгенерить рандомній пароль состоящий из 4 гласніх 3 согласніх и 5 цифр

//    public static void createRandomPassword() {
//        Random random = new Random();
//        int num = 0;
//        String nums = "";
//        String smallLetter = "";
//        String bigLetter = "";
//        String letter = "";
//
//        for (int i = 0; i < 26; i++) {
//            num = random.nextInt(0, 10);
//            nums = nums + num;
//        }
//        for (int i = 0; i < 26; i++) {
//            char a = (char) (random.nextInt(26) + 'a');
//            smallLetter = smallLetter + a;
//            char b = (char) (random.nextInt(26) + 'A');
//            bigLetter = bigLetter + b;
//        }
//        letter = smallLetter + bigLetter + nums;
//        char[] arr = letter.toCharArray();
//        System.out.println(" Basic array " + Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length; i++) {
//            int randomIndex = random.nextInt(arr.length);
//            char buffer = arr[i];
//            arr[i] = arr[randomIndex];
//            arr[randomIndex] = buffer;
//        }
//        System.out.println(" Random array " + Arrays.toString(arr));
//
//        String password = "";
//        for (int i = 0, number = 0, vowels = 0, consonant = 0; i < arr.length; i++) {
//            if ((arr[i] >= '0') && (arr[i] <= '9') && (number < 5)) {
//                password = password + arr[i];
//                number++;
//            }
//            if ((arr[i] == 'a' || arr[i] == 'A' || arr[i] == 'e' || arr[i] == 'E' ||
//                    arr[i] == 'y' || arr[i] == 'Y' || arr[i] == 'u' || arr[i] == 'U' ||
//                    arr[i] == 'i' || arr[i] == 'I' || arr[i] == 'o' || arr[i] == 'O') && (vowels < 3)) {
//                password = password + arr[i];
//                vowels++;
//            }
//            //b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, and z.
//            if ((arr[i] == 'b' || arr[i] == 'B' || arr[i] == 'c' || arr[i] == 'C' ||
//                    arr[i] == 'd' || arr[i] == 'D' || arr[i] == 'f' || arr[i] == 'F' ||
//                    arr[i] == 'g' || arr[i] == 'G' || arr[i] == 'h' || arr[i] == 'H' ||
//                    arr[i] == 'j' || arr[i] == 'J' || arr[i] == 'k' || arr[i] == 'K' ||
//                    arr[i] == 'l' || arr[i] == 'L' || arr[i] == 'm' || arr[i] == 'M' ||
//                    arr[i] == 'n' || arr[i] == 'N' || arr[i] == 'p' || arr[i] == 'P' ||
//                    arr[i] == 'q' || arr[i] == 'Q' || arr[i] == 'r' || arr[i] == 'R' ||
//                    arr[i] == 's' || arr[i] == 'S' || arr[i] == 't' || arr[i] == 'T' ||
//                    arr[i] == 'v' || arr[i] == 'V' || arr[i] == 'w' || arr[i] == 'W' ||
//                    arr[i] == 'x' || arr[i] == 'X' || arr[i] == 'z' || arr[i] == 'Z') && (consonant < 4)) {
//
//                password = password + arr[i];
//                consonant++;
//            }
//        }
//        System.out.println(" Random password " + password);
//    }
    // переделать

    public static void createRandomPassword() {
        Random random = new Random();
        String basicPass = "";
        for (int i = 0, number = 0, vowels = 0, consonant = 0; ; i++) {
            char randomChar = (char) random.nextInt('0', 'z');
            if ((randomChar >= 'A' && randomChar <= 'Z')
                    || (randomChar >= 'a' && randomChar <= 'z')
                    || (randomChar >= '0' && randomChar <= '9')) {
                if ((randomChar == 'a' || randomChar == 'e' ||
                        randomChar == 'y' || randomChar == 'u' ||
                        randomChar == 'i' || randomChar == 'o' ||
                        randomChar == 'A' || randomChar == 'E' ||
                        randomChar == 'Y' || randomChar == 'U' ||
                        randomChar == 'I' || randomChar == 'O') && (vowels < 3)) {
                    basicPass = basicPass + randomChar;
                    vowels++;
                } else if ((randomChar >= '0' && randomChar <= '9') && (number < 5)) {
                    basicPass = basicPass + randomChar;
                    number++;
                } else if (consonant < 4) {
                    basicPass = basicPass + randomChar;
                    consonant++;
                }
            }
            //System.out.println("Random char: " + randomChar);
            if (number == 5 && consonant == 4 && vowels == 3) {
                break;
            }
        }
        System.out.println("First result password " + basicPass);
//        char[] password = basicPass.toCharArray();
//        for (int i = 0; i < password.length; i++) {
//            int rIndex = random.nextInt(0, password.length);
//            char buffer = password[i];
//            password[i] = password[rIndex];
//            password[rIndex] = buffer;
//        }
//        basicPass = "";
//        for (int i = 0; i < password.length; i++) {
//            basicPass = basicPass + password[i];
//        }
//        System.out.println("last result password " + basicPass);

    }

    //принимаем стринг и возвращает стринг с символами, которые встречаются чаще всего
    public static char returnMaxAmountSymbol(String text) {
        char[] arr = text.toCharArray();
        char symbol = arr[0];
        int etalonCounter = 0;
        int currentCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            currentCounter++;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    currentCounter++;
                }
            }
            if (currentCounter > etalonCounter) {
                symbol = arr[i];
                etalonCounter = currentCounter;
            }
            currentCounter = 0;
        }
        return symbol;
    }

    //принимаем инт и возвращаем кол-во шагов для превращения этого числа в симметричное относительно центра число
    public static int getAmountStepsToMirror(int numb) {
        // кол-во шагов до получения зеркального состояния
        int amountStep = 0;
        while (!isMirror(numb)) {
            amountStep++;
            numb = numb + reverseInt(numb);
            //System.out.println(numb);
        }
        return amountStep;
    }

    public static int reverseInt(int number) {
        // развернуть число зеркально

        int sum = 0;
        char[] num = ("" + number).toCharArray();
        for (int i = 0, j = 1; i < num.length; i++, j = j * 10) {
            sum = sum + (num[i] - '0') * j;
        }
        return sum;
    }

    public static boolean isMirror(int number) {
        // является ли число зеркальным

        char[] arr = ("" + number).toCharArray();
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    //ф-я принимает стринг и чар и возвращает массив стрингов, полученный разбиением стринга на набор стрингов чаром, что передается
    public static String[] t(String text, char a) {
        char[] arr = text.toCharArray();
        int counter = 0;
        String text2 = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                counter++;
            }
        }
        System.out.println(counter);
        String[] arrText = new String[counter + 1];
        String textIndex = "";
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != a) {
                textIndex = textIndex + arr[i];
            } else {
                arrText[j] = textIndex;
                textIndex = "";
                j++;
            }
            if (i == arr.length - 1) {
                arrText[j] = textIndex;
            }
        }
        return arrText;
    }

    // 1) ф-я принимает стринг и возвращает стринг, в котором максимальная и минимальная цмфры поменяны местами
    public static String getMinMaxNums(String t) {
        char[] arr = t.toCharArray();
        System.out.println("Base array = " + Arrays.toString(arr));
        int max = 0;
        int min = 9;
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (max < (arr[i] - '0')) {
                    max = (arr[i] - '0');
                    indexMax = i;
                    // System.out.println("max " + max);
                }
                if (min > (arr[i] - '0')) {
                    min = (arr[i] - '0');
                    indexMin = i;
                    // System.out.println("min " + min);
                }
            }
        }
        char bufferIndexMax = arr[indexMax];
        arr[indexMax] = arr[indexMin];
        arr[indexMin] = bufferIndexMax;
        t = "";
        for (int i = 0; i < arr.length; i++) t = t + arr[i];
        return t;
    }

    // 2) принимаем стринг и возвращаем максимальное количество подряд идущих цифр

    public static int getAmountNumbs(String t) {
        char[] arr = t.toCharArray();
        System.out.println(" arrayNumbs = " + Arrays.toString(arr));
        int currentCounter = 1;
        int mainCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= '0' && arr[i] <= '9') || (i == arr.length - 1)) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] >= '0' && arr[j] <= '9') {
                        currentCounter++;
                    } else
                        break;
                }
                if (mainCounter < currentCounter) mainCounter = currentCounter;
                currentCounter = 1;
            }
        }
        System.out.println(" currentCounter = " + currentCounter);
        System.out.println(" mainCounter = " + mainCounter);
        return mainCounter;
    }

    // 3) принимаем стринг и возвращаем стринг без повторов элементов
    // уже решена - строка 478



}

