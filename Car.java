import java.util.Scanner;

public class Car<T> extends Engine implements Participant, Cloneable {

    private static int numberOfCars = 0;

    private T id;
    private String brand;
    private boolean rate;
    protected Fuel fuel;

    public Car() {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = false;
        numberOfCars++;
    }

    public Car(String brand) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = false;
        numberOfCars++;
    }

    public Car(boolean rate) {
        this.fuel = new Fuel();
        this.brand = "";
        this.rate = rate;
        numberOfCars++;
    }

    public Car(String brand, boolean rate) {
        this.fuel = new Fuel();
        this.brand = brand;
        this.rate = rate;
        numberOfCars++;
    }

    public Car(T id, String brand, boolean rate) {
        this.fuel = new Fuel();
        this.id = id;
        this.brand = brand;
        this.rate = rate;
        numberOfCars++;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    public void setID(T id) {
        this.id = id;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    public boolean getRate() {
        return this.rate;
    }

    public T getID() {
        return this.id;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        String temp; boolean flag;
        System.out.println("** Ввод данных автомобиля **");
        do {
            System.out.print("Введите марку: ");
            this.brand = scanner.nextLine();
            flag = Checking.nameCheck(this.brand);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        do {
            System.out.print("Введите класс автомобиля (0 - Эконом, 1 - Комфорт): ");
            temp = scanner.nextLine();
            flag = Checking.booleanCheck(temp);
            if (!flag) System.out.print("Попробуйте ещё раз. ");
        } while (!flag);
        if (temp.equals("1"))
            this.rate = true;
        else
            this.rate = false;
        System.out.println("Данные успешно введены!\n");
    }

    @Override
    public String toString() {
        if (this.brand.equals("")) {
            throw new IllegalArgumentException("Отсутствует марка Автомобиля!");
        }
        else {
            String buffer = "Данные об автомобиле:\n-ID: " + this.id + "\n-Марка: " + this.brand + "\n-Класс: ";
            if (this.rate) {
                buffer += "Комфорт\n";
            } else {
                buffer += "Эконом\n";
            }
            return buffer;
        }
    }

    @Override
    public Car<T> clone() throws CloneNotSupportedException {
        Car<T> newCar = (Car<T>) super.clone();
        newCar.fuel = (Fuel) fuel.clone();
        return newCar;
    }
}
