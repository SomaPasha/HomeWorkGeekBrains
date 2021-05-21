package lesson5;

public class Employee {
    private String fullName;
    private String post;
    private String email;
    private String telephone ;
    private int theSalary;
    private int  age;


    public Employee(String fullName,String post,String email, String telephone,int theSalary, int age){
        this.fullName = fullName;
        this.post =post;
        this.email =email;
        this.telephone = telephone;
        this.theSalary = theSalary;
        this.age =age;
    }

    public int getAge() {
        return age;
    }

    public void writeInfo(){
        System.out.printf(
                "ФИО:         %s \n" +
                "Должность:   %s \n" +
                "Мыло:        %s \n" +
                "Телефон:     %s \n" +
                "Зарплата:    %d \n" +
                "Возраст:     %d \n", fullName,post,email,  telephone, theSalary,  age );
    }



}
