package arrays;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class ArrayTest {
    public static void main(String[] args) {
        int a = 4;
        int[] array = {6, 9, -1, 3, 5};
        System.out.println(array[3]);
        array[1] = 28;
        System.out.println(" " + Arrays.toString(array));
        int size = array.length;
        int i = 9;
        System.out.println(" " + size);
        for (i = 0; i < array.length; i = i + 1) {
            System.out.println(array[i]);
        }
        System.out.println("-------");
// цикл с конца
        for (i = array.length - 1; i >= 0; i = i - 1) {
            System.out.println(array[i]);
        }
        boolean[] arrayBoolean = new boolean[50];
        System.out.println(Arrays.toString(arrayBoolean));
        double[] arrayDouble = new double[50];
        System.out.println(Arrays.toString(arrayDouble));

        char[] arrayChar = new char[]{'l', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(arrayChar));
        //есть инт - размер массива типа инт/ Заполнить его случайными числами от 2 до 17

        Random generator = new Random();
        int random = 0;
        int arraySize = 15;
        int[] arrayNumber = new int[arraySize];
        for (i = 0; i < arraySize; i = i + 1) {
            random = generator.nextInt(2, 18);
            arrayNumber[i] = random;
        }
        System.out.println(Arrays.toString(arrayNumber));

//          Домашка 1
////        Bohdan, [29.02.2024 18:11]
////        1) есть массив типа инт со значениями/ Найти максимум и минимум

        int bufferMax = 0;
        int bufferMin = 0;
        int[] arraySymbol = {-888881, -56666666, -355565666, 45, 55, 16, 58, 24, 99, 2345, -583};
        System.out.println(Arrays.toString(arraySymbol));
        System.out.println(arraySymbol.length);
        bufferMax = arraySymbol[0];
        bufferMin = arraySymbol[0];
        for (i = 1; i < arraySymbol.length; i = i + 1) {
            if (arraySymbol[i] > bufferMax) {
                bufferMax = arraySymbol[i];
            } else if (arraySymbol[i] < bufferMin) {
                bufferMin = arraySymbol[i];
            }
        }
        System.out.println("Макс значение в массиве " + bufferMax);
        System.out.println("Мин значение в массиве " + bufferMin);
        System.out.println("__________________");

        //          Домашка 2
//        Bohdan, [29.02.2024 18:11]
//        2)есть массив типа чар/ Найти количество разных символов в нем исключая буквы и цифры

        int randomIntNew = 0;
        int randomInt = 0;
        int counter = 0;
        size = 20;
        arrayChar = new char[size];

        for (i = 0; i < size; i = i + 1) {
            randomInt = generator.nextInt(33, 127);
            arrayChar[i] = (char) randomInt;
            randomIntNew = arrayChar[i];
            if (!((randomIntNew >= 48 && randomIntNew <= 57) || (randomIntNew >= 65 && randomIntNew <= 90) || (randomIntNew >= 97 && randomIntNew <= 122))) {
                counter = counter + 1;
            }
        }
        System.out.println(Arrays.toString(arrayChar));
        System.out.println("Кол-во символов кроме букв и цифр = " + counter);
        System.out.println("__________________");

        //          Домашка 3
//        Bohdan, [29.02.2024 18:11]
//        3) создать массив типа булень на 20 ячеек и заполнить его случайными буленями/ Кого в нем больше?

        int counterTrue = 0;
        int counterFalse = 0;
        boolean randomBoolean;
        arrayBoolean = new boolean[20];
        for (i = 0; i < arrayBoolean.length; i = i + 1) {
            randomBoolean = generator.nextBoolean();
            arrayBoolean[i] = randomBoolean;

            if (arrayBoolean[i]) {
                counterTrue = counterTrue + 1;
            } else {
                counterFalse = counterFalse + 1;
            }
        }
        System.out.println(Arrays.toString(arrayBoolean));
        System.out.println("Amount of True " + counterTrue);
        System.out.println("Amount of False " + counterFalse);

        int[] arrayInt = {10, 12, 15, 258, 66, 78, 111, 87, 99, 321, 23, 12};
        int[] newArray = new int[5];
        System.arraycopy(arrayInt, 3, newArray, 0, newArray.length);
        System.out.println(Arrays.toString(newArray));

        //удалить последнюю ячейуц

        int[] arrayIntNew = new int[arrayInt.length - 1];
        System.arraycopy(arrayInt, 0, arrayIntNew, 0, arrayIntNew.length);
        System.out.println(Arrays.toString(arrayIntNew));
        //первую ячейку

        int[] arrayIntNewOne = new int[arrayIntNew.length - 1];
        System.arraycopy(arrayIntNew, 1, arrayIntNewOne, 0, arrayIntNewOne.length);
        System.out.println(Arrays.toString(arrayIntNewOne));
//есть 2 массива, склеить их

        int[] arrayHuge = new int[arrayIntNew.length + arrayIntNewOne.length];
        System.arraycopy(arrayIntNew, 0, arrayHuge, 0, arrayIntNew.length);
        System.arraycopy(arrayIntNewOne, 0, arrayHuge, arrayIntNew.length, arrayIntNewOne.length);
        System.out.println(Arrays.toString(arrayHuge));


        // home task 1
//есть массив и инт число - номер ячейки для удаления

        int randomNumber = 4;
        int[] arrayOfNumbers = {2, 5, 8, 9, 12, 78, 55, 125};
        int[] newArrayOfNumbers = new int[arrayOfNumbers.length - 1];
        System.arraycopy(arrayOfNumbers, 0, newArrayOfNumbers, 0, randomNumber - 1);
        System.arraycopy(arrayOfNumbers, randomNumber, newArrayOfNumbers, randomNumber - 1, arrayOfNumbers.length - randomNumber);

        System.out.println(Arrays.toString(arrayOfNumbers));
        System.out.println(Arrays.toString(newArrayOfNumbers));

        // home task 1
// удалить 2 ячейки подряд

        int randomNumber1 = 2;

        int[] arrayOfNumbers1 = {2, 5, 8, 9, 12, 78, 55, 125};
        int[] newArrayOfNumbers1 = new int[arrayOfNumbers.length - 2];
        System.arraycopy(arrayOfNumbers1, 0, newArrayOfNumbers1, 0, randomNumber1 - 1);
        System.arraycopy(arrayOfNumbers1, randomNumber1 + 1, newArrayOfNumbers1, randomNumber1 - 1, arrayOfNumbers1.length - (randomNumber1 + 1));

        System.out.println(Arrays.toString(arrayOfNumbers1));
        System.out.println(Arrays.toString(newArrayOfNumbers1));
        System.out.println("есть массив интов и 2 инта");

        // home task 1
        //      1)есть массив интов и 2 инта, первый - что вставляется, второй - куда вставляется

        int what = 99999;
        int where = 0; // index
        int[] arr = {108, 122, 1512, 2458, 6116, 178, 1911, 787, 99, 321, 23, 77, 100};
        int[] arrayOld = new int[arr.length + 1];
        arrayOld[where] = what;

        System.arraycopy(arr, 0, arrayOld, 0, where);
        System.arraycopy(arr, where, arrayOld, where + 1, arr.length - where);
        System.out.println(Arrays.toString(arrayOld));
        System.out.println("есть 2 массива типа инт и инт число");

// home task 2
//        2)есть 2 массива типа инт и инт число - номер ячейки куда второй массив вставляется в первый

        int[] arrOne = {10, 12, 678, 25128, 66, -78, 111, 87, 99, 321, 23, 77, 100};
        int[] arrTwo = {12, 25, 36, 65, 98, 4};
        int[] arrBoth = new int[arrOne.length + arrTwo.length];
        int numb = 0;

        System.arraycopy(arrOne, 0, arrBoth, 0, numb);
        System.arraycopy(arrTwo, 0, arrBoth, numb, arrTwo.length);
        System.arraycopy(arrOne, numb, arrBoth, numb + arrTwo.length, arrOne.length - numb);
        System.out.println(Arrays.toString(arrBoth));
        System.out.println("********************");

//        1) дано 2 массива -1) 5 интов 2) пустой с 10 ячйками
//        сскопировать первый массив во второй полностью на позицию int position=4
//
//        {12, 25, 36, 65, 98}
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        Exp.: {0, 0, 0, 0, 12, 25, 36, 65, 98, 0}

        int[] arrCloud = {1, 2, 3, 4, 5};
        int[] arrCloudNew = new int[10];
        int position = 4;

        System.arraycopy(arrCloud, 0, arrCloudNew, position, arrCloud.length);
        System.out.println(Arrays.toString(arrCloudNew));
        System.out.println("********************");

//        2)дано 2 массива 1)5 интов 2)пустой 10 ячеек
//        скопировать с позиции int position = 2 на позицию int newPosition = 6 3 числа

        int[] arrFirst = {1, 2, 3, 4, 5};
        int[] arrSecond = new int[10];
        int positionFrom = 2;
        int positionTo = 6;

//        {12, 25, 36, 65, 98}
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        Exp.: {0, 0, 0, 0, 0, 0, 36,65,98, 0}

        System.arraycopy(arrFirst, positionFrom, arrSecond, positionTo, arrFirst.length - positionFrom);
        System.out.println(Arrays.toString(arrSecond));
        System.out.println("********************");

//        3)дaно 2 массива 1) 5 интов 2) пустой на 10 ячеек
//        скопировать первые 2 числа на позицию 3
//        и последние 2 числа на позицию 8

//        {12, 25, 36, 65, 98}
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        Exp.: {0, 0, 0, 12, 25, 0, 0, 0, 65, 98}

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];
        int positionFirstPLace = 3;
        int positionSecondPlace = 8;

        System.arraycopy(arr1, 0, arr2, positionFirstPLace, 2);
        System.arraycopy(arr1, arr1.length - 2, arr2, positionSecondPlace, 2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("Сортировка");

        //

        int[] massive = {0, -122, 78, 5, 8, 78, 9, 45, 78, 3, 3, 20};
        Arrays.sort(massive);
        System.out.println(Arrays.toString(massive));
        //найтм макс и ми
        System.out.println("min =" + massive[0]);
        System.out.println("max =" + massive[massive.length - 1]);
        //найти второй максимум в массиве
        // System.out.println("second max =" + massive[massive.length - 2]);


        int max = massive[massive.length - 1];
        int secondMax = max;
        for (i = massive.length - 1; i >= 0; i = i - 1) {
            if (massive[i] != max) {
                secondMax = massive[i];
                break;
            }
        }
        System.out.println("secondMax = " + secondMax);

        System.out.println("1) есть массив мнтов/ Найти максимальное произведение двух чисел из массива");

//        1) есть массив мнтов/ Найти максимальное произведение двух чисел из массива (это могут быть и одинаковые числа если их несколько)

        int[] list = {-78, 9, 45, -2778, 3, 3, -5, -6, 0, 666, 777, 888};
        //  {-2778, -78, -6, -5, 0, 3, 3, 9, 45, 666, 777, 888 };
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

        int maxPositiveOne = list[list.length - 1];
        int maxPositiveTwo = list[list.length - 2];
        int minNegativeOne = list[0];
        int minNegativeTwo = list[1];

        int resultPositive = maxPositiveOne * maxPositiveTwo;
        int resultNegative = minNegativeOne * minNegativeTwo;

        if (resultPositive > resultNegative) {
            System.out.println("максимальное произведение двух чисел из массива =" + resultPositive);
        } else {
            System.out.println("максимальное произведение двух чисел из массива =" + resultNegative);
        }

        System.out.println("2) макс произведение 3-х чисел из массива");

//        2) макс произведение 3-х чисел из массива

        int[] listY = {-78, 9, 45, -2778, 3, 3, -5, 487, -24, 5, -6, 0, 666, 777, 888};
        Arrays.sort(listY);
        System.out.println(Arrays.toString(listY));
        int multiplyOne = 1;
        int multiplyTwo = 1;

        for (i = 0; i < 3; i = i + 1) {
            multiplyOne = listY[i] * multiplyOne;
            // System.out.println("first loop "+multiplyOne);
        }
        for (i = listY.length - 1; i > listY.length - 4; i = i - 1) {
            multiplyTwo = listY[i] * multiplyTwo;
            // System.out.println("second loop "+multiplyTwo);
        }
        System.out.println(Math.max(multiplyOne, multiplyTwo));


        System.out.println("3)найти второй минимум в массиве");

//        3)найти второй минимум в массиве

        int[] root = {5, 5, 5, 5, 5, 5, 5, 5, 5};
        Arrays.sort(root);
        System.out.println(Arrays.toString(root));
        int min1 = root[0];
        int min2 = min1;
        for (i = 0; i < root.length; i = i + 1) {
            if (root[i] != min1) {
                min2 = root[i];
                break;
            }
        }
        System.out.println(min2);

        System.out.println("4) есть массив и инт число - номер ячейки для удаления");

//        4) есть массив и инт число - номер ячейки для удаления

        int[] arrays = {45, 6, 7, 89, 11, 78, 9, 3};
        int socet = 7;
        int[] newArrays = new int[arrays.length - 1];

        System.arraycopy(arrays, 0, newArrays, 0, socet);
        System.arraycopy(arrays, socet + 1, newArrays, socet, arrays.length - socet - 1);
        System.out.println(Arrays.toString(newArrays));

        //есть массив интов/ Все положительные в нем числа сделать отрицательными и наоборот
        int[] plus = {78, 12, 45, 99, 15, 66, 5, -12, -25};
        for (i = 0; i < plus.length; plus[i] = -plus[i], i = i + 1) ;
        System.out.println(Arrays.toString(plus));
        //инвертировать массив буленей

        boolean[] bool = {true, false, false, false, false, true, false, true};
        for (i = 0; i < bool.length; bool[i] = !bool[i], i++) ;
        System.out.println(Arrays.toString(bool));

        // в массиве даблов все положительные числа уменьшить на 21% а отрицательные увеличить в 1.5 раза
        double[] doubles = {1.45, -2.67, -45.55, 78.5, 8.99, -245.12};
        for (i = 0; i < doubles.length; i = i + 1) {
            if (doubles[i] > 0) {
                doubles[i] = doubles[i] * 0.79;

            } else {
                doubles[i] = doubles[i] * 0.5;

            }
            doubles[i] = Math.round(doubles[i] * 100.0) / 100.0;
        }
        System.out.println(Arrays.toString(doubles));


        System.out.println("1) есть массив интов. Найти среднее положительніх єлементов массива с конца до первого отрицательного\n");
        // 1) есть массив интов. Найти среднее положительніх єлементов массива с конца до первого отрицательного
        double sum = 0.0;
        counter = 0;
        double average = 0.0;
        // double averageround = 0.0;
        int[] poolsNumb = {1, 5, 7, 6, 8, 0, 123, -85, 12, -96, -78, 7, 6, 8, 200, 45, 800, 15};
        for (i = poolsNumb.length - 1; i >= 0; i = i - 1) {
            if (poolsNumb[i] > 0) {
                sum = sum + poolsNumb[i];
                counter = counter + 1;

            } else {
                break;
            }
        }
        average = sum / counter;
        average = Math.round(average * 100) / 100.0;

        System.out.println(sum);
        System.out.println(counter);
        System.out.println(average);
        // System.out.println(averageround);


        System.out.println("2) есть массив  интов . Создать новій массив - копию исходного используя цикл фор а не эрейкопи\n");
        //2) есть массив  интов . Создать новій массив - копию исходного используя цикл фор а не эрейкопи

        int[] pools = {1, 5, 7, 6, 8, 0, 123, 45};
        int[] newpools = new int[pools.length];
        for (i = 0; i < newpools.length; i = i + 1) {
            newpools[i] = pools[i];
        }
        System.out.println(Arrays.toString(pools));
        System.out.println(Arrays.toString(newpools));

        System.out.println("3)удалить последнюю ячейку массива/ использовать цикл");
        // 3)удалить последнюю ячейку массива/ использовать цикл

        int[] pool = {1, 5, 7, 6, 8, 99, -25};
        int[] newpool = new int[pool.length - 1];
        for (i = 0; i < newpool.length; i = i + 1) {
            newpool[i] = pool[i];
        }
        System.out.println(Arrays.toString(pool));
        System.out.println(Arrays.toString(newpool));

        System.out.println("4)удалить первую ячейку используя цикл");
        //4)удалить первую ячейку используя цикл

        int[] poolOld = {1, 5, 7, 6, 8};
        int[] poolCopy = new int[poolOld.length - 1];
        for (i = 0; i < poolCopy.length; i = i + 1) {
            poolCopy[i] = poolOld[i + 1];
        }
        System.out.println(Arrays.toString(poolOld));
        System.out.println(Arrays.toString(poolCopy));
        //есть массив интов/ создать новый, в котором будут только положительные элементы исходного

        int counterPositive = 0;
        int[] poolDefolt = {-12, 25, -45, 6, 8, -10, 19};

        for (i = 0; i < poolDefolt.length; i = i + 1) {
            if (poolDefolt[i] > 0) {
                counterPositive = counterPositive + 1;
            }
        }
        System.out.println(counterPositive);
        int[] poolPositive = new int[counterPositive];

        for (int h = 0, j = 0; h < poolDefolt.length; h = h + 1) {
            if (poolDefolt[h] > 0)
                poolPositive[j++] = poolDefolt[h];
        }
        System.out.println(Arrays.toString(poolPositive));
        // есть массив интов/ Сделать оборотня

        int[] nums = {-12, 25, -45, 6, 8, -10, 19};
        int[] newNums = new int[nums.length];
        for (int f = nums.length - 1, j = 0; f >= 0; j = j + 1, f = f - 1)
            newNums[j] = nums[f];
        System.out.println(Arrays.toString(newNums));


        System.out.println("Домашнее задание № 1 - есть 2 массива/ Склеить их используя цикл");
        int[] oneArrayInt = {-12, 25, -45, 6, 8};
        int[] twoArrayInt = {89, 45, 99};
        int[] arrayBoth = new int[oneArrayInt.length + twoArrayInt.length];

        for (i = 0; i < oneArrayInt.length; i = i + 1) {
            arrayBoth[i] = oneArrayInt[i];
            if (i < twoArrayInt.length) {
                arrayBoth[i + oneArrayInt.length] = twoArrayInt[i];
            }
        }
        System.out.println(Arrays.toString(oneArrayInt));
        System.out.println(Arrays.toString(twoArrayInt));
        System.out.println(Arrays.toString(arrayBoth));


        System.out.println("Домашнее задание № 2 - есть массив и инт - номер ячейки для удаления (циклом)");

        int[] arrayRemove = {89, 45, 99, 102, 520, 63, 141};
        int numbRemove = 0;
        int[] arrayAfterDelete = new int[arrayRemove.length - 1];
        for (i = 0; i < arrayAfterDelete.length; i = i + 1) {

            if (i >= numbRemove) {
                arrayAfterDelete[i] = arrayRemove[i + 1];
            } else {
                arrayAfterDelete[i] = arrayRemove[i];
            }
        }
        System.out.println(Arrays.toString(arrayAfterDelete));


        System.out.println("Домашнее задание № 3 - есть массив и 2 инта/ Первый что вставить. второй - куда. Фором");

        int[] arrayOfInteger = {89, 45, 99, 102, 520, 200};
        int inputWhat = 300;
        int inputWhere = 6; // индекс ячейки
        int[] newArrayOfInteger = new int[arrayOfInteger.length + 1];

        for (int z = 0; z < arrayOfInteger.length; z++) {
            if (z < inputWhere) {
                newArrayOfInteger[z] = arrayOfInteger[z];
            } else {
                newArrayOfInteger[z + 1] = arrayOfInteger[z];
            }
        }
        newArrayOfInteger[inputWhere] = inputWhat;

        System.out.println(Arrays.toString(newArrayOfInteger));


//есть массив/ Сделать оборотня в себе

        pool = new int[]{2, 5, 6, 1, 7, 8, 4};
        int buffer = 0;
        for (int p = 0, o = pool.length - 1; o > pool.length / 2; p++, o--) {
            buffer = pool[p];
            pool[p] = pool[o];
            pool[o] = buffer;
        }
        System.out.println(Arrays.toString(pool));
        System.out.println("есть массив/ Смешать его как колоду карт");

        int[] arrayPool = {5, 12, 11, 45, 63, 100};
        int randomIndex = 0;
        buffer = 0;
        for (int x = 0; x < arrayPool.length - 1; x = x + 1) {
            randomIndex = generator.nextInt(arrayPool.length);
            buffer = arrayPool[x];
            arrayPool[x] = arrayPool[randomIndex];
            arrayPool[randomIndex] = buffer;

        }
        System.out.println(Arrays.toString(arrayPool));

        //Task 1 - 22/03
        System.out.println("***//есть массив типа инт с равным количеством положительных и отрицательных/ Сделать в шахматном порядке (минус - плюс - минус - плюс)\n");
        int[] arrayChess = {-12, -15, 78, 45, 12, -125, 65, 7, -5, -66};
        Arrays.sort(arrayChess);
        int j = arrayChess.length - 2;
        for (i = 1; i < arrayChess.length / 2; i = i + 2, j = j - 2) {
            buffer = arrayChess[i];
            arrayChess[i] = arrayChess[j];
            arrayChess[j] = buffer;
        }
        System.out.println(Arrays.toString(arrayChess));

        System.out.println("//есть число типа инт/ Найти произведение все[ чисел  от него и до 0");
        int num = 5;
        int result = 1;
        for (i = 1; i <= num; i++) {
            result = i * result;
        }
        System.out.println(result);

        System.out.println("есть массив. Прокрутить все его элементы вправо на одну позицию");
        int[] bar = {10, 12, 5, 8, 9, 99};
        buffer = bar[bar.length - 1];
        System.arraycopy(bar, 0, bar, 1, bar.length - 1);
        bar[0] = buffer;
        System.out.println(Arrays.toString(bar));

// Task 2 - 22/03
        System.out.println("домой - сместить влево все элементы");
        buffer = bar[0];
        System.arraycopy(bar, 1, bar, 0, bar.length - 1);
        bar[bar.length - 1] = buffer;
        System.out.println(Arrays.toString(bar));


        System.out.println("New Changes ========= есть массив интов/ Создать массив буленей такой же длины, и важдой ячейке буленевского стоит тру, если число в массиве интов делится на предыдущее без остатка\n");
        System.out.println("changes ------------ Создать массив буленей такой же длины, и важдой ячейке буленевского стоит тру, если число в массиве интов делится на предыдущее без остатка\n");

        int[] goal = {77, 4, 32, 6, 5, 4, 16, 3, 1, 11, 222};
        boolean[] goalBool = new boolean[goal.length];
        for (i = 1; i < goal.length - 1; i++) {
            if ((goal[i] % goal[i - 1]) == 0) {
                goalBool[i] = true;
            } else {
                goalBool[i] = false;
            }
        }
        System.out.println(Arrays.toString(goal));
        System.out.println(Arrays.toString(goalBool));

// Task 3 - 22/03
        System.out.println("Есть 2 массива и инт число - номер ячейки, куда второй массив вставляется в первый (одним фором)");
        int[] geek1 = {77, 6, 5, 4, 16, 11, 222};
        int[] geek2 = {10, 20, 30, 40};
        int whereInput = 6;
        int[] bothArray = new int[geek1.length + geek2.length];

        for (i = 0; i < bothArray.length; i++) {
            if (i < whereInput) {
                bothArray[i] = geek1[i];
            } else if (i >= whereInput && i < (whereInput) + geek2.length) {
                bothArray[i] = geek2[i - (whereInput)];
            } else if (i >= (whereInput) + geek2.length) {
                bothArray[i] = geek1[i - geek2.length];
            }
        }
        System.out.println(Arrays.toString(bothArray));

// Task 4 - 22/03
        System.out.println("есть 2 инта/ Сделать массив, в который поместить все числа от первого до второго включительно");

        int num1 = 10;
        int num2 = 55;
        int[] num3 = new int[num2 - num1 + 1];
        for (i = 0; i < num3.length; i++) {
            num3[i] = num1 + i;
        }
        System.out.println(Arrays.toString(num3));
        System.out.println("Прокртутить эелементы массива на 1 позицию - циклом");

        int[] arrayNum = {1, 5, 6, 90, 11, 86, 100};
        buffer = arrayNum[arrayNum.length - 1];
        for (i = arrayNum.length - 1; i > 0; i = i - 1) {
            arrayNum[i] = arrayNum[i - 1];
        }
        arrayNum[0] = buffer;
        System.out.println(Arrays.toString(arrayNum));
        //тоже - но в другую сторону циклом

        System.out.println("//тоже - но в другую сторону циклом");
        int[] arrayNumNew = {100, 1, 5, 6, 90, 11, 86};
        int bufferNew = arrayNumNew[0];
        for (i = 1; i < arrayNumNew.length; i = i + 1) {
            arrayNumNew[i - 1] = arrayNumNew[i];
        }
        arrayNumNew[arrayNumNew.length - 1] = bufferNew;
        System.out.println(Arrays.toString(arrayNumNew));

        System.out.println();
        System.out.println("Похожая задача");


        int[] multiply1 = {1, 5, 6, 90, 11, 86, 100, 4, 9, 14, 99, 5, 7};
        int[] newMultiply1 = new int[multiply1.length - 1];
        for (i = 1; i < multiply1.length; i++) {
            newMultiply1[i - 1] = multiply1[i] * multiply1[i - 1];
        }
        System.out.println(Arrays.toString(multiply1));
        System.out.println(Arrays.toString(newMultiply1));


        System.out.println();
        System.out.println("Home Work №1 - создать массив на 29 ячеек и заполнить его числами 4 и 9 последовательно");
        int[] numbers = new int[29];
        int four = 4;
        int nine = 9;
        for (i = 0; i < numbers.length; i++) numbers[i] = numbers[i] != i % 2 ? nine : four;
        System.out.println(Arrays.toString(numbers));

//        {
//            if (i % 2 != 0) {
//                numbers[i] = nine;
//            } else {
//                numbers[i] = four;
//            }
//        }

        System.out.println();
        System.out.println("Home Work №2 -  есть массив интов. В нем сделать так, чтобі на каждой позиции стояло значение - результат произведения єлемента в позиции на предідущий");
        int[] multiply = {1, 5, 6, 90, 11, 86, 100, 4, 9, 14, 99, 5, 7};
        int[] newMultiply = new int[multiply.length];
        for (i = 1; i < newMultiply.length; i++) {
            newMultiply[i] = multiply[i] * multiply[i - 1];
        }
        System.out.println(Arrays.toString(multiply));
        System.out.println(Arrays.toString(newMultiply));

        System.out.println();
        System.out.println("//есть массив типа инт/ Найти в нем второй максимум используя цикл фор");
        int[] arrayMax = {90, 11, 86, 100, 4, 9, 100, 250, 6589};
        int max1 = arrayMax[0];
        int max2 = arrayMax[0];
        for (i = 0; i < arrayMax.length; i = i + 1) {
            if (arrayMax[i] > max1) {
                max2 = max1;
                max1 = arrayMax[i];
            } else if (max1 >= arrayMax[i] && arrayMax[i] > max2) {
                max2 = arrayMax[i];
            }
        }
        System.out.println(Arrays.toString(arrayMax));
        System.out.println(max1);
        System.out.println(max2);

        System.out.println();
        System.out.println("Home Work №1 - /есть массив интов/ Найти количество элементов, больших среднего в массиве");
        int[] arrayNumbers = {90, 11, 86, 100, 4, 9, 10, 250, 50, 100, 23, 92, 66, 77, 88, 99};
        double sumArrayNumbers = 0.0;
        int counterAverageAmount = 0;

        for (i = 0; i < arrayNumbers.length; i++) {
            sumArrayNumbers = arrayNumbers[i] + sumArrayNumbers;
        }
        double averageAmount = sumArrayNumbers / arrayNumbers.length;
        averageAmount = Math.round(averageAmount * 100) / 100.0;

        for (i = 0; i < arrayNumbers.length; i++) {
            if (averageAmount < arrayNumbers[i]) {
                counterAverageAmount++;
            }
        }
        Arrays.sort(arrayNumbers);
        System.out.println(Arrays.toString(arrayNumbers));
        System.out.println("Сумма значений массива = " + sumArrayNumbers);
        System.out.println("Среднее значение = " + averageAmount);
        System.out.println("Кол-во элементов = " + counterAverageAmount);


    }
}
