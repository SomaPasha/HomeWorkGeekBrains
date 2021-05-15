package lesson3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessingWorld {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String answerWorld = randomWorlds(words);
        System.out.println(answerWorld);
        char[] letters = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

        while (true) {

            String riddleWorld = sc.nextLine();
            int finish = 0;
            riddleWorld.toLowerCase();
            int quantityLetter = 0;

            if (answerWorld.length() >= riddleWorld.length()) {
                quantityLetter = riddleWorld.length();
            } else {
                quantityLetter = answerWorld.length();
            }


            for (int i = 0; i <= quantityLetter - 1; i++) {
                if (answerWorld.charAt(i) == riddleWorld.charAt(i)) {
                    letters[i] = answerWorld.charAt(i);
                    finish++;
                }
            }

            if (finish == answerWorld.length() && answerWorld.equals(riddleWorld)) {
                System.out.println(answerWorld);
                System.out.println("Вы угадали");
                break;
            } else {
                writeWorld(letters);
            }

        }


        sc.close();

    }


    public static String randomWorlds(String[] worlds) {
        return worlds[rand.nextInt(worlds.length)];
    }

    public static void writeWorld(char[] letters) {
        for (char lett : letters) {
            System.out.print(lett);
        }
        System.out.println();
    }
}
