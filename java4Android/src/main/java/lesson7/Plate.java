package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void descreaseFood(int appetite){
       if  ((food - appetite)>=0){
           food -= appetite;
       }
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public  void  info(){
        System.out.println("В тарелке: " + food + " еды.");
    }
}
