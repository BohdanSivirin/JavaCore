package functions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Function3 {
    //ф-я принимает исходное время (часы  мин   сек) и заряд
    // батареи и печатает сремя посекундно в формате (чч:мм:сс)
    // Разрядка 1 процент за 4 часа

    public static void printTime(int hours, int minute, int seconds, int charge) {

        for (int recharge = 0; charge > recharge; seconds++) {
            if (seconds == 60) {
                minute++;
                seconds = 0;
                if (minute == 60) {
                    minute = 0;
                    hours++;
                    if (hours == 4) {
                        recharge++;
                    }
                    if (hours == 24) {
                        hours = 0;
                    }
                }
            }

            System.out.println((hours <= 9 ? "0" + hours : hours) + ":"
                    + (minute <= 9 ? "0" + minute : minute) + ":" + (seconds <= 9 ? "0" + seconds : seconds));
//            String min = "0";
//            String hou = "0";
//            String p = ":";
//
//            if (seconds < 10) {
//                System.out.println(hours + p + minute + p + sec + seconds);
//            } else if (minute < 10) {
//                System.out.println(hours + p + min + minute + p + seconds);
//            } else if (hours < 10) {
//                System.out.println(hou + hours + p + minute + p + seconds);
//            }
        }
    }

    // принимаем массив интов и сортируйм по убыванию
    public static void sortArrayFromMaxToMin(int[] arr) {
        System.out.println(" HW 1 - ");
        System.out.println(" Base Int = " + Arrays.toString(arr));

        int buffer = arr[0];
        for (int i = arr.length - 1; i >= 0; i--) {
            int minIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            buffer = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = buffer;
        }
        System.out.println(" принимаем массив интов и сортируйм по убыванию = " + Arrays.toString(arr));
    }

    //принимаем массив стрингов и сортируем по возрастанию длин стрингов
    public static void sortStringToLonger(String[] text) {
        System.out.println(" HW 2 - ");
        System.out.println(" Base String = " + Arrays.toString(text));
//        System.out.println(text[text.length - 1].length());

        for (int i = text.length - 1; i >= 0; i--) {
            int maxIndex = 0;
            String buffer = "";

            for (int j = 0; j <= i; j++) {
                if (text[j].length() > text[maxIndex].length()) {
                    maxIndex = j;
                }
            }
            buffer = text[maxIndex];
            text[maxIndex] = text[i];
            text[i] = buffer;
        }
        System.out.println(" принимаем массив стрингов и сортируем по возрастанию длин стрингов = "
                + Arrays.toString(text));
    }

    //ф-я принимает инт массив и сотрирует его по возрастанию
    public static void sortArray(int[] arr) {
        int buffer = arr[0];
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = 0;

            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            buffer = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = buffer;
        }
        System.out.println(" принимает инт массив и сотрирует его по возрастанию = " + Arrays.toString(arr));
    }


}
