package lesson7;

import java.util.ArrayList;

public class Main {
    public   static ArrayList<Cat> zooCat = new ArrayList<Cat>();
    public  static void main(String[] args) {
        Cat cat1 = new Cat("Багира", 100);
        Cat cat2 = new Cat("Котофей", 10);
        Cat cat3 = new Cat("Мурка", 120);
        Cat cat4 = new Cat("Барсик", 20);
        Cat cat5 = new Cat("Мурзик", 50);
        Cat cat6 = new Cat("Вася", 60);
        Cat cat7 = new Cat("Леопольд", 400);
        Cat cat8 = new Cat("Серик", 230);
        Cat cat9 = new Cat("Феликс", 220);
        Cat cat10 = new Cat("Тимка", 9);
        Cat cat11 = new Cat("Лиза", 100);
        Plate plate = new Plate(990);
        // добавление еды
        plate.addFood(10);
        // создание массива котов
        createArrCat(cat1,cat2,cat3,cat4,cat5,cat6, cat7,cat8,cat9,cat10,cat11);
        // Цикл котов
        for (Cat cat: zooCat) {
           cat.eat(plate);
           System.out.println(cat.getName() + " поел(а): " +cat.isSatiety());
           plate.info();
        }
    }

    public static void createArrCat(Cat... cat){
        for (Cat i: cat) {
            zooCat.add(i);
        }
    }
}
