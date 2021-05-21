package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArr = new Employee[5];
        employeeArr[0] = new Employee("Иванов Иван Иввнович", "Электрик", "ivivan@mailbox.com", "892312312", 30000, 30);
        employeeArr[1] = new Employee("Кузнецов Павел Игоревич", "Врач", "pavel@mailbox.com", "892343312", 20000, 43);
        employeeArr[2] = new Employee("Владимиров Иван Сергеевич", "Педагог", "ivivan1@mailbox.com", "892313312", 10000, 21);
        employeeArr[3] = new Employee("Герлах Александр Владимирович", "Психолог", "alex@mailbox.com", "892512312", 40000, 11);
        employeeArr[4] = new Employee("Босых Константин Валерьевич", "Повар", "const@mailbox.com", "8923312312", 50000, 49);
        System.out.println("Информация о сотрудниках: \n");

        for (int i = 0; i < employeeArr.length; i++) {
            if(employeeArr[i].getAge()>=40) {
                employeeArr[i].writeInfo();
               System.out. println();
            }


        }
    }
}
