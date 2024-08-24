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

        char up = '\u2191';
        char down = '\u2193';
        char left = '\u2190';
        char right = '\u2192';

        int playerScore = 0;
        int amountOfTreasure = getAmountOfTreasureByLevel(level);

        for (; ; ) {
            System.out.println(" Сделай ход: 1 , 2 , 3 ");
            System.out.println(" 1 - вперед, 2 - влево, 3 - вправо ");
            int playerMove = scanner.nextInt();

            if (playerMove == 2) {
                playerArrow = turnArrowLeft(playerArrow);
                createBoard[positionPlayer_I][positionPlayer_J] = playerArrow;
            }
            if (playerMove == 3) {
                playerArrow = turnArrowRight(playerArrow);
                createBoard[positionPlayer_I][positionPlayer_J] = playerArrow;
            }
//            if (playerMove == 1) {
//                boolean checkNextStep = checkNextStep(playerArrow, createBoard, positionPlayer_I, positionPlayer_J);
//                if (checkNextStep) {
//                    if (playerArrow == down) {
//                        createBoard[positionPlayer_I][positionPlayer_J] = ' ';
//                        createBoard[positionPlayer_I + 1][positionPlayer_J] = playerArrow;
//                    }
//                    if (playerArrow == up) {
//                        createBoard[positionPlayer_I][positionPlayer_J] = ' ';
//                        createBoard[positionPlayer_I - 1][positionPlayer_J] = playerArrow;
//                    }
//                    if (playerArrow == left) {
//                        createBoard[positionPlayer_I][positionPlayer_J] = ' ';
//                        createBoard[positionPlayer_I][positionPlayer_J - 1] = playerArrow;
//                    }
//                    if (playerArrow == right) {
//                        createBoard[positionPlayer_I][positionPlayer_J] = ' ';
//                        createBoard[positionPlayer_I][positionPlayer_J + 1] = playerArrow;
//                    }
//                } else System.out.println("Нельзя сделать ход прямо");
//            }

            printBoard(createBoard);
        }
    }

    private static boolean checkNextStep(char playerArrow, char[][] createBoard,
                                         int positionPlayer_I, int positionPlayer_J) {
        char up = '\u2191';
        char down = '\u2193';
        char left = '\u2190';
        char right = '\u2192';

        if (playerArrow == down && positionPlayer_I == createBoard.length - 1) {
            return false;
        } else if (playerArrow == up && positionPlayer_I == 0) {
            return false;
        } else if (playerArrow == left && positionPlayer_J == 0) {
            return false;
        } else if (playerArrow == right) {
            if (createBoard[positionPlayer_I][positionPlayer_J + 1] == ' ' ||
                    createBoard[positionPlayer_I][positionPlayer_J + 1] == '$') {
                return true;
            }
//            else if (positionPlayer_J == createBoard[positionPlayer_I].length - 1 || createBoard[positionPlayer_I][positionPlayer_J + 1] == 'X') {
//                return false;
//            }
        }
        return false;
    }

    private static char turnArrowLeft(char arrow) {
        char up = '\u2191';
        char down = '\u2193';
        char left = '\u2190';
        char right = '\u2192';

        if (arrow == up) {
            arrow = left;
        } else if (arrow == left) {
            arrow = down;
        } else if (arrow == down) {
            arrow = right;
        } else if (arrow == right) {
            arrow = up;
        }
        return arrow;
    }

    public static char turnArrowRight(char arrow) {
        char up = '\u2191';
        char down = '\u2193';
        char left = '\u2190';
        char right = '\u2192';

        if (arrow == up) {
            arrow = right;
        } else if (arrow == right) {
            arrow = down;
        } else if (arrow == down) {
            arrow = left;
        } else if (arrow == left) {
            arrow = up;
        }
        return arrow;
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

    private static int getAmountOfTreasureByLevel(int level) {
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
