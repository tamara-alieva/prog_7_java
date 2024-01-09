import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger extends Person {
    private boolean payment_method;

    public Passenger() {
        super();
        this.payment_method = false;
    }

    public Passenger(String name) {
        super(name);
        this.payment_method = false;
    }

    public Passenger(int balance) {
        super(balance);
        this.payment_method = false;
    }

    public Passenger(String name, int balance, boolean method) {
        super(name, balance);
        this.payment_method = method;
    }

    public void setMethod(boolean method) {
        this.payment_method = method;
    }

    public void setInfo(String name, int balance, boolean method) {
        setInfo(name, balance);
        this.payment_method = method;
    }

    public boolean getMethod() {
        return this.payment_method;
    }

    @Override
    public void input() {
        String temp; boolean flag;
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Ввод данных о пассажире: " + this.getName() + " **");
        do {
            System.out.print("Введите способ оплаты (0 - Наличные, 1 - Банковская карта): ");
            temp = scanner.nextLine();
            flag = Checking.booleanCheck(temp);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        if (temp.equals("1"))
            this.payment_method = true;
        else
            this.payment_method = false;
        System.out.println("Данные успешно введены!\n");
    }

    @Override
    public void output() {
        if (this.name.equals("")) {
            throw new IllegalArgumentException("Отсутствует имя Пассажира!");
        }
        else {
            System.out.println("Данные о пассажире:");
            System.out.println("-Имя: " + this.name);
            System.out.println("-Баланс: " + this.balance);
            System.out.print("-Способ оплаты: ");
            if (this.payment_method) {
                System.out.println("Банковская карта\n");
            } else {
                System.out.println("Наличные\n");
            }
        }
    }

    @Override
    public String toString() {
        if (this.name.equals("")) {
            throw new IllegalArgumentException("Отсутствует имя Пассажира!");
        }
        else {
            String buffer = "Данные о пассажире:\n-Имя: " + this.name + "\n-Баланс: " + this.balance + "\n-Способ оплаты: ";
            if (this.payment_method) {
                buffer += "Банковская карта\n";
            } else {
                buffer += "Наличные\n";
            }
            return buffer;
        }
    }

    public void takePayment(int payment) {
        int old_balance = this.getBalance();
        this.setBalance(old_balance - payment);
    }
}
