package lesson6;

import java.util.ArrayList;

class Zoo {
    private ArrayList<Animal> arrAnimal = new ArrayList<Animal>();

    public void addAnimal(Animal... animal) {
        for (Animal arr : animal) {
            arrAnimal.add(arr);
        }

    }

    public ArrayList<Animal> getAnimal() {
        return arrAnimal;
    }
}

class Animal {
    private String name;
    private static int quantityAnimal = 0;

    Animal() {
        this.name = "Неизвестный(ая)";
        quantityAnimal++;
    }

    Animal(String name) {
        this.name = name;
        quantityAnimal++;
    }

    public static int getQuantityAnimal() {
        return quantityAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int distanse, int limit) {
        if (distanse <= limit) {
            System.out.println(this.name + " run: " + (distanse <= limit));
        } else {
            System.out.println(this.name + " run: " + (distanse <= limit));
        }
        //   System.out.println(this.name + " пробежал(а) " + distanse + " м. true");
    }

    public void swim(int distanse, int limit) {
        if (distanse <= limit) {
            System.out.println(this.name + " swim: " + (distanse <= limit));
        } else {
            System.out.println(this.name + " swim: " + (distanse <= limit));
        }
    }

    public void jump(float height, float limit) {
        if (height <= limit) {
            System.out.println(this.name + " jump: " + (height <= limit));
        } else {
            System.out.println(this.name + " jump: " + (height <= limit));
        }
    }
}

class Cat extends Animal {
    private static int quantityCat = 0;

    public Cat() {
        super();
        setName(getName() + " кот");
        quantityCat++;

    }


    public Cat(String name) {
        super(name + " кот");
        quantityCat++;
    }

    public static int getQuantityCat() {
        return quantityCat;
    }

    @Override
    public void swim(int distanse, int limit) {
        System.out.println(getName() + " swim false");
    }
}

class Dog extends Animal {
    private static int quantityDog = 0;

    public Dog() {
        super();
        setName(getName() + " собака");
        quantityDog++;
    }

    public Dog(String name) {
        super(name + " собака");
        quantityDog++;
    }

    public static int getQuantityDog() {
        return quantityDog;
    }

}

public class Main {
    private static int quantityCat = 0;
    private static int quantityAnimal = 0;
    private static int quantityDog = 0;

    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        Animal animal = new Animal("Зверь");
        Animal animal1 = new Animal();
        Cat cat = new Cat();
        Cat cat1 = new Cat("Багира");
        Dog dog = new Dog();
        Dog dog1 = new Dog("Шарик");
        animal.run(1000, 100000);
        animal1.run(1000, 100000);
        cat.run(100, 200);
        cat1.run(100, 200);
        dog.run(100, 400);
        dog1.run(700, 600);

        animal.swim(1, 10000);
        animal1.swim(1, 10000);
        cat.swim(1, 0);
        cat1.swim(1, 0);
        dog.swim(1, 10);
        dog1.swim(1, 10);

        animal.jump(1, 10);
        animal1.jump(1, 10);
        cat.jump(1, 2);
        cat1.jump(1, 2);
        dog.jump((float) 0.3, 0.5F);
        dog1.jump(10, 0.5F);

        zoo.addAnimal(animal, animal1, cat, cat1, dog, dog1);
        zoo.getAnimal().forEach(ani -> {
            if (ani instanceof Cat) {
                quantityCat++;
            }
            if (ani instanceof Dog) {
                quantityDog++;
            }
            quantityAnimal++;
        });

        countQuantityAnimalAndByCategory();
    }

    public static void countQuantityAnimalAndByCategory() {
        //Реализация подсчёта через static
        System.out.println("Итого создано: \n" + Animal.getQuantityAnimal() + " животных.\n"
                + Cat.getQuantityCat() + " котов.\n"
                + Dog.getQuantityDog() + " собак.");
        //Реализация подсчёта через Класс Зоопарк
        System.out.println("Итого создано: \n" + quantityAnimal + " животных.\n"
                + quantityCat + " котов.\n"
                + quantityDog + " собак.");
    }


}
