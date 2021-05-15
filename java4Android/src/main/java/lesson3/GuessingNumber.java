package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Random rand = new Random();
        while (true) {
            int attempt = 3;
            int answer = rand.nextInt(10);
            while (true) {
                if (attempt == 0) {
                    System.out.println("Вы проиграли");
                    break;
                }
                int riddleNumber = getNumberFromScanner("Угадайте число от 0 до 9", 0, 9);
                if (answer == riddleNumber) {
                    System.out.println("Вы выйграли");
                    break;
                } else if (answer < riddleNumber) {
                    System.out.println("Загаданное число меньше");
                    attempt--;
                    System.out.println("У вас осталось " + attempt+ " попытка(ов)");
                } else if (answer > riddleNumber) {
                    System.out.println("Загаданное число больше");
                    attempt--;
                    System.out.println("У вас осталось " + attempt+ " попытка(ов)");
                }

            }
            int repeat = getNumberFromScanner("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1);
            if (repeat == 0) {
                break;
            }
        }
        sc.close();
    }


    public static int getNumberFromScanner(String message, int min, int max) {
        int number;
        do {
            System.out.println(message);
            number = sc.nextInt();

        } while (number < min || number > max);
        return number;
    }


}
