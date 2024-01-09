import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ТЕСТЫ:");
        System.out.println("1) Перегруженный метод setInfo(...) в классе Passenger (с вызовом метода класса Person)");
        Passenger passenger1 = new Passenger();
        passenger1.setInfo("Иван", 5000, false);
        System.out.println(passenger1);

        System.out.println("2) Перегруженный метод setInfo(...) в классе Driver (без вызова метода класса Person)");
        Driver driver1 = new Driver();
        driver1.setInfo("Леонид", 8700, 14, 390);
        System.out.println(driver1);

        System.out.println("3) Вызов конструктора базового класса из конструктора производного класса");
        Passenger passenger2 = new Passenger("Георгий", 5000, true);
        System.out.println(passenger2);

        System.out.println("4) Абстрактный класс Engine -> класс Car");
        Car car1 = new Car("Volvo", true);
        System.out.println("getBrand(): " + car1.getBrand());

        System.out.println("\n5) Интерфейс Participant и его метод input()");
        Fuel fuel1 = new Fuel();
        fuel1.input();

        /*
        System.out.println("\n6) Мелкое клонирование");
        try {
            Car<Integer> car_original1 = new Car(12345, "Toyota", false);
            Car<Integer> car_copy1 = car_original1.clone();
            car_copy1.fuel.fill();
            System.out.println("Оригинальный объект:");
            System.out.println(car_original1);
            System.out.println(car_original1.fuel);
            System.out.println("\nОбъект-клон:");
            System.out.println(car_copy1);
            System.out.println(car_copy1.fuel);
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Не применён интерфейс Cloneable!");
        }
        */

        System.out.println("\n7) Глубокое клонирование");
        try {
            Car<Integer> car_original2 = new Car(12345, "Toyota", false);
            Car<Integer> car_copy2 = car_original2.clone();
            car_copy2.fuel.fill();
            System.out.println("Оригинальный объект:");
            System.out.println(car_original2);
            System.out.println(car_original2.fuel);
            System.out.println("\nОбъект-клон:");
            System.out.println(car_copy2);
            System.out.println(car_copy2.fuel);
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Не применён интерфейс Cloneable!");
        }
        
        System.out.println("\n8) Шаблон класса Car");
        Car<Integer> car2 = new Car(12345, "Volkswagen", true);
        System.out.println(car2);
    }
}
