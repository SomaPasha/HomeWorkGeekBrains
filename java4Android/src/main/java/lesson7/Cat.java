package lesson7;

public class Cat {
    private  String name;
    private  int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety=false;
    }

    public  void eat(Plate p){
        if (p.getFood() -appetite>=0){satiety=true;} else {satiety=false;}
        p.descreaseFood(appetite);

    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
