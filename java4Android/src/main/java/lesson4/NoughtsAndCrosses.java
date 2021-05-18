package lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
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
            x=scanner.nextInt()-1;
            y=scanner.nextInt()-1;
        } while (!CellValid(x,y));
        map[x][y] = DOT_X;
    }

    public static boolean CellValid(int x, int y) {
        if (x<0||x>=SIZE || y<0 ||y<=SIZE){
            return false;
        }
        if (map[x][y]==DOT_EMPTY) {
            return true;
        }
        return false;
    }



}
