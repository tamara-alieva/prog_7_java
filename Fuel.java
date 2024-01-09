import java.util.Scanner;

public class Fuel implements Participant, Cloneable {
    private boolean capacity;

    public Fuel() {
        this.capacity = false;
    }

    public Fuel(boolean capacity) {
        this.capacity = capacity;
    }

    public void setCapacity(boolean capacity) {
        this.capacity = capacity;
    }

    public boolean getCapacity() {
        return this.capacity;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp; boolean flag;
        System.out.println("** Ввод данных о топливном баке **");
        do {
            System.out.print("Введите заполенность бака (0 - Пустой, 1 - Полный): ");
            temp = scanner.nextLine();
            flag = Checking.booleanCheck(temp);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        if (temp.equals("1"))
            this.capacity = true;
        else
            this.capacity = false;
    }

    @Override
    public String toString() {
        String buffer = "Данные о топливном баке:\n-Заполненность: ";
        if (this.getCapacity()) {
            buffer += "Полный\n";
        } else {
            buffer +="Пустой\n";
        }
        return buffer;
    }

    public void fill() {
        this.capacity = true;
    }

    public void empty() {
        this.capacity = false;
    }

    public Fuel clone() throws CloneNotSupportedException {
        return (Fuel) super.clone();
    }
}
