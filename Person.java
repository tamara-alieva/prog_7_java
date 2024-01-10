import java.util.Scanner;

public class Person implements Participant {
    protected String type;
    protected String name;
    protected int balance;

    public Person() {
        type = "Person";
        this.name = "";
        this.balance = 0;
    }

    public Person(String name) {
        type = "Person";
        this.name = name;
        this.balance = 0;
    }

    public Person(int balance) {
        type = "Person";
        this.name = "";
        this.balance = balance;
    }

    public Person(String name, int balance) {
        type = "Person";
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setInfo(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp; boolean flag; int f;
        System.out.println("** Ввод данных человека **");
        do {
            System.out.print("Введите имя: ");
            this.name = scanner.nextLine();
            flag = Checking.nameCheck(this.name);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        
        do {
            System.out.print("Введите баланс: ");
            temp = scanner.nextLine();
            f = Checking.intCheck(temp);
            if (f == 0) System.out.print("Попробуйте ещё раз. ");
        } while (f == 0);
        this.balance = Integer.parseInt(temp);
        System.out.println("Данные успешно введены!\n");
    }

    public void output() {
        if (this.name.equals("")) {
            throw new IllegalArgumentException("Отсутствует имя Человека!");
        } else {
            System.out.println("Данные о человеке:");
            System.out.println("-Имя: " + this.name);
            System.out.println("-Баланс: " + this.balance);
        }
    }

    @Override
    public String toString() {
        if (this.name.equals("")) {
            throw new IllegalArgumentException("Отсутствует имя Человека!");
        } else {
            return "Данные о человеке:\n-Имя: " + this.name + "\n-Баланс: " + this.balance + '\n';
        }
    }
}
