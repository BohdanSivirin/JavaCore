package game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) {
        startGame();

    }

    public static void startGame() {
        char[][] board = createBoard(2, 3);
        printBoard(board);

        Random random = new Random();
        char player = random.nextBoolean() ? 'X' : 'O';

        Scanner scaner = new Scanner(System.in);

        int totalScorePlayerX = 0;
        int totalScorePlayerO = 0;


        for (; ; ) {
            int counter = 0;
            for (int k = 0; k < board[0].length; k++) {
                if (board[0][k] != ' ') {
                    counter++;
                }
            }
            if (counter == board[0].length) {
                System.out.println(" Ничья ");
                return;
            }

            System.out.println(player + " Введи номер столбца ");
            int column = scaner.nextInt();

            if (board[0][column] != ' ') {
                System.out.println(" Введи номер другого столбца ");
                continue;
            }

            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][column] == ' ') {
                    board[i][column] = player;

                    if (i > 0 && i < board.length - 2) {
                        if ((board[i + 1][column] == player) && (board[i + 2][column] == player)) {
                            board[i][column] = ' ';
                            board[i + 1][column] = ' ';
                            board[i + 2][column] = ' ';
                            System.out.println(player + " Получил + 1 очко ");

                            if (player == 'X') {
                                totalScorePlayerX = totalScorePlayerX + 1;
                            } else totalScorePlayerO = totalScorePlayerO + 1;

                            if (totalScorePlayerX == 3) {
                                System.out.println(" Победил игрок - 'X' ");
                                return;
                            } else if (totalScorePlayerO == 3) {
                                System.out.println(" Победил игрок - 'O' ");
                                return;
                            }
                            System.out.println(" Общий счет игры = " + totalScorePlayerX + " | " + totalScorePlayerO);


                        }
                    }
                    break;
                }
            }
            printBoard(board);
            player = player == 'X' ? 'O' : 'X';

        }
    }

    private static void printBoard(char[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " " + Arrays.toString(arr[i]));
        }
        System.out.print("   ");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println(" ");
    }

    private static char[][] createBoard(int size1, int size2) {
        char[][] arr = new char[size1][size2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }


}
