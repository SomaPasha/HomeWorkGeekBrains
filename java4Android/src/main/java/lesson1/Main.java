package lesson1;

public class Main {
    public static void main(String[] args) {
        int in = 10;
        byte byt= -127;
        short shor = -32000;
        long  lon = 1123;
        double dou = 13.23;
        float floa = 145.2f;
        char cha = 'c';
        boolean bool = true;
        String strin = "stringggg";
        int a = 10;
        int b = 20;
        int c=40;
        int d= 5;
        int year = 1404;
        String  name  = "Павел";
        System.out.println("Cумма выражения равна = " + expression(a,b,c,d));
        System.out.println("Сумма двух чисел находиться в диапазоне от 10 до 20? " + range(a,b));
        System.out.println( "Число "+plusAndMinus(a));
        System.out.println( "Число "+plusAndMinusBool(a));
        personName(name);
        visocov(year);


    }
    public  static String plusAndMinus(int ch){
        if(ch>=0) return "Положительное"; else return "Отрицательное";
    }

    public  static boolean plusAndMinusBool(int ch){
        if(ch>=0) return false; else return true;
    }
    public  static int expression(int a, int b, int c,int d) {
        return  a * (b + (c / d));

    }
    public  static boolean range(int a, int b) {
        int c = a+b;
        if ((c>=10)&&(c<=20)) return true; else  return false;
    }
    public static void personName(String name){
        System.out.println("Привет, "+ name + "!");
    }
    public  static  void  visocov(int year){
        if(year % 400 ==0 ){

            System.out.println("Високосный год");
        }
        else if (year % 100 ==0){
            System.out.println("Год не високосный");
        }
        else if (year % 4 ==0){
            System.out.println("Високосный год");
        }  else  System.out.println("Год не високосный");

    }
}
