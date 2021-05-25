package lesson6;

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

    public void run(int distanse) {
        System.out.println(this.name + " пробежал(а) " + distanse + " м.");
    }

    public void swim(int distanse) {
        System.out.println(this.name + " проплыл(а) " + distanse + " м.");
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
    public void run(int distanse) {
        if (distanse <= 200) {
            super.run(distanse);
        } else {
            System.out.println(getName() + " может пробежать только 200 м. Осталось " + (distanse - 200));
        }
    }

    @Override
    public void swim(int distanse) {
        System.out.println(getName() + " не умеет плавать");
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

    @Override
    public void run(int distanse) {
        if (distanse <= 500) {
            super.run(distanse);
        } else {
            System.out.println(getName() + " может пробежать только 500 м. Осталось  " + (distanse - 500));
        }
    }

    @Override
    public void swim(int distanse) {
        if (distanse <= 10) {
            super.swim(distanse);
        } else {
            System.out.println(getName() + " может проплыть только 10 м. Осталось " + (distanse - 10));
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Зверь");
        Animal animal1 = new Animal();
        Cat cat = new Cat();
        Cat cat1 = new Cat("Багира");
        Dog dog = new Dog();
        Dog dog1 = new Dog("Шарик");
        animal.run(1000);
        animal1.run(1000);
        cat.run(1000);
        cat1.run(1000);
        dog.run(1000);
        dog1.run(1000);

        animal.swim(1);
        animal1.swim(1);
        cat.swim(1);
        cat1.swim(1);
        dog.swim(1);
        dog1.swim(1);
        countQuantityAnimalAndByCategory();

    }

    public static void countQuantityAnimalAndByCategory() {
        System.out.println("Итого создано: \n" + Animal.getQuantityAnimal() + " животных.\n"
                + Cat.getQuantityCat() + " котов.\n"
                + Dog.getQuantityDog() + " собак.");
    }


}
