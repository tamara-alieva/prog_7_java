import java.util.Scanner;

public class Driver extends Person {
    private int experience;
    private int orderAmount;

    public Driver() {
        super();
        type = "Driver";
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(String name) {
        super(name);
        type = "Driver";
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(int balance) {
        super(balance);
        type = "Driver";
        this.experience = 0;
        this.orderAmount = 0;
    }

    public Driver(String name, int balance, int experience, int orderAmount) {
        super(name, balance);
        type = "Driver";
        this.experience = experience;
        this.orderAmount = orderAmount;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setInfo(String name, int balance, int experience, int orderAmount) {
        this.name = name;
        this.balance = balance;
        this.experience = experience;
        this.orderAmount = orderAmount;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getOrderAmount() {
        return this.orderAmount;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp = ""; int flag;
        System.out.println("** Ввод данных водителя: " + this.name + " **");
        do {
            System.out.print("Введите количество лет опыта: ");
            temp = scanner.nextLine();
            flag = Checking.intCheck(temp);
            if (flag == 0) System.out.print("Попробуйте ещё раз. ");
        } while (flag == 0);
        this.experience = Integer.parseInt(temp);
        temp = "";
        do {
            System.out.print("Введите количество выполненных заказов: ");
            temp = scanner.nextLine();
            flag = Checking.intCheck(temp);
            if (flag == 0) System.out.print("Попробуйте ещё раз. ");
        } while (flag == 0);
        this.orderAmount = Integer.parseInt(temp);
        System.out.println("Данные успешно введены!\n");
    }

    @Override
    public String toString() {
        if (this.name.equals("")) {
            throw new IllegalArgumentException("Отсутствует имя Водителя!");
        }
        else {
            return "Данные о водителе:\n-Имя: " + this.name + "\n-Баланс: " + this.balance + "\n-Количество лет опыта: " + this.experience + "\n-Количество выполненных заказов: " + this.orderAmount + '\n';
        }
    }

    public void givePayment(int payment) {
        int old_balance = this.getBalance();
        this.setBalance(old_balance + payment);
    }

    public void increaseOrderAmount() {
        int old_amount = this.getOrderAmount();
        this.setOrderAmount(old_amount + 1);
    }
}
