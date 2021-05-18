package lesson4;

import java.awt.font.GraphicAttribute;
import java.sql.Struct;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinO(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinO(DOT_O)) {
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
        if (map[x][y] == DOT_EMPTY) {
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
        do {
            System.out.println("Введите координаты в формате X и Y ");
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!CellValid(x, y));
        map[x][y] = DOT_O;
    }

    public static boolean checkWinO(char sym) {
        if (map[0][0] == sym && map[0][1] == sym && map[0][2] == sym) return true;
        if (map[1][0] == sym && map[1][1] == sym && map[1][2] == sym) return true;
        if (map[2][0] == sym && map[2][1] == sym && map[2][2] == sym) return true;
        if (map[0][0] == sym && map[1][0] == sym && map[2][0] == sym) return true;
        if (map[0][1] == sym && map[1][1] == sym && map[2][1] == sym) return true;
        if (map[0][2] == sym && map[1][2] == sym && map[2][2] == sym) return true;
        if (map[0][0] == sym && map[1][1] == sym && map[2][2] == sym) return true;
        if (map[2][0] == sym && map[1][1] == sym && map[0][2] == sym) return true;
        return false;
    }


}
