package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 1};
        invertArray();
        fillArray();
        changeArray();
        fillDiagonalArray(5);
        minAndMaxArray();
        System.out.println("6)   ");
        System.out.println("   " + equalSummaDelimiter(arr));
        int number = 2;
        int array[] = {4, 3, 5, 1};
        displaceArray(array, number);

    }

    public static void invertArray() {
        int[] mass = new int[10];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) (Math.random() * 2);
        }
        System.out.println("1)   " + Arrays.toString(mass));
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 1) {
                mass[i] = 0;
            } else {
                mass[i] = 1;
            }
        }
        System.out.println("     Измененный массив");
        System.out.println("     " + Arrays.toString(mass));
    }

    public static void fillArray() {
        int[] mass = new int[8];
        int result = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = result;
            result = result + 3;
        }
        System.out.println("2)   " + Arrays.toString(mass));
    }

    public static void changeArray() {
        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] = mass[i] * 2;
            }
        }
        System.out.println("3)   " + Arrays.toString(mass));
    }

    public static void fillDiagonalArray(int size) {
        int[][] mass = new int[size][size];
        System.out.println("4)");
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (i == j) {
                    mass[i][j] = 1;
                    System.out.print(mass[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void minAndMaxArray() {
        System.out.print("5) ");
        int min = 100;
        int max = 0;
        int[] mass = new int[10];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) (Math.random() * min);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] >= max) {
                max = mass[i];
            }
            if (mass[i] <= min) {
                min = mass[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }

    public static boolean equalSummaDelimiter(int[] arr) {
        int delimiter = 1;
        while (true) {
            if (summaDelimiter(arr, delimiter)) {
               writeArrayDelimiter(arr, delimiter);
                return true;
            }
            delimiter++;
            if (delimiter == arr.length) {
                writeArrayDelimiter(arr);
                return false;
            }
        }


    }

    public static boolean summaDelimiter(int[] arr, int delimiter) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            if (delimiter < i) {
                left = left + arr[i];
            } else {
                right = right + arr[i];
            }
        }
        if (right == left) {
            return true;
        } else {
            return false;
        }

    }

    public static void writeArrayDelimiter(int[] arr, int delimiter) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
            if (delimiter == i) {
                System.out.print("|| ");
            }
        }
        System.out.print("]");
    }

    public static void writeArrayDelimiter(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }

    public static void displaceArray(int[] arr, int number) {
        System.out.println(Arrays.toString(arr));
        if (number > 0) {
            while (number>0){
              arr=oneDisplaceRight(arr);
                number--;
            }
        } else {
            while (number<0){
               arr= oneDisplaceLeft(arr);
                number++;
            }

        }

        System.out.println(Arrays.toString(arr));
    }

    public static int[] oneDisplaceRight(int[] arr) {
        int[] arrTime = new int[arr.length];
        arrTime[0] = arr[arr.length - 1];
        for (int i = 0; i < (arr.length - 1); i++) {
            arrTime[i + 1] = arr[i];
        }
        return arrTime;
    }

    public static int[] oneDisplaceLeft(int[] arr) {
        int[] arrTime = new int[arr.length];
        arrTime[arr.length - 1] = arr[0];
        for (int i = 0; i < (arr.length - 1); i++) {
            arrTime[i] = arr[i + 1];
        }
        return arrTime;
    }
}