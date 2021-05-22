package lesson4;

import java.util.Random;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static char[][] map;
    public static final int DOTS_TO_WIN = 3;
    public static final int SIZE = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static int iax, iay = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            generateXAndYai();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            generateXAndYai();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void generateXAndYai(){
        if (!isMapFull()){ do {
            iax = random.nextInt(SIZE);
            iay = random.nextInt(SIZE);
        } while (!CellValid(iax, iay));
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X и Y ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!CellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean CellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;

        map[iay][iax] = DOT_O;
    }

    public static boolean checkWin(char sym) {

        if (checkHorizontal(sym) || checkVertical(sym) || checkDiagonal(sym)) {
            return true;
        }
        return false;
    }

    private static boolean checkVertical(char sym) {
        int popeda = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == sym) {
                    popeda++;
                    if (popeda == DOTS_TO_WIN) {
                        return true;
                    }
                    blok(popeda, i, j + 1, sym);
                } else popeda = 0;
            }
            popeda = 0;
        }
        return false;
    }

    private static boolean checkHorizontal(char sym) {
        int popeda = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == sym) {
                    popeda++;
                    if (popeda == DOTS_TO_WIN) {
                        return true;
                    }
                    blok(popeda, j + 1, i, sym);
                } else popeda = 0;
            }
            popeda = 0;
        }
        return false;
    }

    private static boolean checkDiagonal(char sym) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkDiagonalLeft(i, j, sym)) {
                    return true;
                }
                if (checkDiagonalRight(i, j, sym)) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean checkDiagonalLeft(int i, int j, char sym) {
        int popeda = 0;
        int l = j;
        for (int k = i; k < SIZE; k++) {
            if (k == SIZE || l == SIZE) {
                break;
            }
            if (map[k][l] == sym) {
                popeda++;
            } else {
                popeda = 0;
            }
            blok(popeda, l + 1, k + 1, sym);
            l++;
            if (popeda == DOTS_TO_WIN) {
                return true;
            }

        }


        return false;
    }

    private static boolean checkDiagonalRight(int i, int j, char sym) {
        int popeda = 0;
        int l = j;
        for (int k = i; k < SIZE; k++) {
            if (k == SIZE || l == -1) {
                break;
            }
            if (map[k][l] == sym) {
                popeda++;
            } else {
                popeda = 0;
            }
            blok(popeda, l - 1, k + 1, sym);
            l--;

            if (popeda == DOTS_TO_WIN) {
                return true;
            }

        }


        return false;

    }

    private static void blok(int popeda, int x, int y, char sym) {

        if (popeda == (DOTS_TO_WIN - 1) && CellValid(x, y) && sym == 'X') {
            iax = x;
            iay = y;
        }

        if (popeda == (DOTS_TO_WIN - 1) && CellValid(x, y-DOTS_TO_WIN) && sym == 'X') {
            iax = x;
            iay = y-DOTS_TO_WIN;

        }
        if (popeda == (DOTS_TO_WIN - 1) && CellValid(x-DOTS_TO_WIN, y) && sym == 'X') {
            iax = x-DOTS_TO_WIN;
            iay = y;
        }

        if (popeda == (DOTS_TO_WIN - 1) && CellValid(x-DOTS_TO_WIN, y-DOTS_TO_WIN) && sym == 'X') {
            iax = x-DOTS_TO_WIN;
            iay = y-DOTS_TO_WIN;
        }

    }


}
