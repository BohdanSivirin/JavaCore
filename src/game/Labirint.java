package game;

import java.util.Arrays;
import java.util.Scanner;

public class Labirint {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбери уровень игры");
        int level = scanner.nextInt();
        char[][] createBoard = createBoard(level);
        int positionPlayer_J = getPlayerPosition_J_ByLevel(level);
        int positionPlayer_I = getPlayerPosition_I_ByLevel(level);
        char playerArrow = getPlayerArrowByLevel(level);
        printBoard(createBoard);
        System.out.println();

        // игрок
        char up = '\u2191';
        char down = '\u2193';
        char left = '\u2190';
        char right = '\u2192';

        int playerScore = 0;
        int amountOfTreasure = getamountOfTreasureByLevel(level);


        for (; ; ) {
            System.out.println(" Сделай ход: 1 , 2 , 3 ");
            System.out.println(" 1 - вперед, 2 - влево, 3 - вправо ");
            int playerMove = scanner.nextInt();

//            if (playerArrow == up)



//            if (playerMove == 1) {
//                if (createBoard[positionPlayer_I + 1][positionPlayer_J] == ' ' ||
//                        createBoard[positionPlayer_I + 1][positionPlayer_J] == '$') {
//                    createBoard[positionPlayer_I + 1][positionPlayer_J] = down;
//                    createBoard[positionPlayer_I][positionPlayer_J] = ' ';
//                    positionPlayer_I = positionPlayer_I + 1;
//
//                }
//                else if ()
//            }
//            printBoard(createBoard);

        }


    }

    private static char getPlayerArrowByLevel(int level) {
        if (level == 1) {
            char down = '\u2193';
            return down;
        } else {
            char left = '\u2190';
            return left;
        }
    }

    private static int getamountOfTreasureByLevel(int level) {
        if (level == 1) {
            return 4;
        } else return 10;
    }

    private static int getPlayerPosition_J_ByLevel(int level) {
        if (level == 1) {
            return 5;
        } else return 10;
    }

    private static int getPlayerPosition_I_ByLevel(int level) {
        if (level == 1) {
            return 0;
        } else return 6;
    }


    private static void printBoard(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " " + Arrays.toString(arr[i]));
        }
        System.out.print("   ");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(i + "  ");
        }
    }


    private static char[][] createBoard(int level) {
        char[][] arr = new char[0][0];
        if (level == 1) {
            arr = new char[][]{
                    {' ', ' ', ' ', ' ', ' ', '\u2193', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X', ' ', 'X'},
                    {'X', '$', 'X', ' ', ' ', ' ', ' ', ' ', 'X', '$', 'X'},
                    {' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X'},
                    {' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', 'X'},
                    {' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', '$', 'X', 'X', '$', ' ', ' ', 'X', ' ', ' ', ' '},
                    {' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' '},
                    {'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            };
        } else if (level == 2) {
            arr = new char[][]{
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                    {' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ',},
                    {'X', '$', ' ', ' ', ' ', ' ', ' ', ' ', 'X', '$', 'X', ' ', ' ', ' ', ' ',},
                    {' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ',},
                    {' ', ' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', '$',},
                    {' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X',},
                    {' ', '$', 'X', 'X', ' ', ' ', ' ', 'X', ' ', ' ', '\u2190', ' ', ' ', 'X', ' ',},
                    {' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', 'X', ' ', ' ',},
                    {'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', ' ',},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', '$', ' ',},
                    {' ', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ',},
                    {'X', '$', 'X', ' ', ' ', ' ', ' ', ' ', 'X', '$', 'X', ' ', ' ', ' ', 'X',},
                    {' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', '$',},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ',},
                    {'X', '$', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X',},
                    {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', '$',},
                    {' ', ' ', 'X', 'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ',},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', 'X', ' ', ' ',},
            };
        }
        return arr;
    }

}
