package game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class СrossesAndToes {
    public static void main(String[] args) {
        whoWinInCrossesAndToes();


    }
    private static void whoWinInCrossesAndToes() {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        printBoard(board);

        Random random = new Random();
        char player = random.nextBoolean() ? 'X' : 'O';

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            System.out.println(player + " Введи число по вертикали");
            int vertical = scanner.nextInt();
            System.out.println(player + " Введи число по горизонтали");
            int horizontal = scanner.nextInt();

            if (!((vertical < 3 && vertical >= 0) && (horizontal < 3 && horizontal >= 0))) {
                System.out.println(" Введите значения от 0 до 2 ");
                i--;
                continue;
            }
            if (board[vertical][horizontal] != ' ') {
                System.out.println(" Неправильный ход, поле занято ");
                i--;
                continue;
            }

            board[vertical][horizontal] = player;
            printBoard(board);
            if (((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) ||
                    ((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)) ||
                    ((board[vertical][0] == player) && (board[vertical][1] == player) && (board[vertical][2] == player)) ||
                    ((board[0][horizontal] == player) && (board[1][horizontal] == player) && (board[2][horizontal] == player))) {
                System.out.println(player + " Вы выиграли");
                return;
            }
            player = player == 'X' ? 'O' : 'X';
        }
        System.out.println(" Ничья ");

    }
    private static void printBoard(char[][] board) {
        System.out.println("  0 " + "  1 " + "  2 ");
        for (int i = 0; i < board.length; i++) {
            System.out.println(i + " " + Arrays.toString(board[i]));
        }
        System.out.print(" ");
    }
}
