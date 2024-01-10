import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void list_output(List<Object> list) {
        int n = list.size(); String buffer;
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s%-15s%-14s%-15s%-20s%-15s |\n", "Type", "Name", "Balance", "Experince", "Order Amount", "Method");
        System.out.println("--------------------------------------------------------------------------------------------------");
        int i;
        Person pers;
        for (i = 0; i < n; i++) {
            pers = (Person) list.get(i);
            if (pers.getType() == "Person") {
                System.out.printf("| %-15s%-15s%-14s%-15s%-20s%-16s|\n", "Person", pers.getName(), pers.getBalance(), "-", "-", "-");
            }
            if (pers.getType() == "Driver") {
                Driver driver = (Driver) list.get(i);
                System.out.printf("| %-15s%-15s%-14s%-15s%-20s%-16s|\n", "Driver", driver.getName(), driver.getBalance(), driver.getExperience(), driver.getOrderAmount(), "-");
            }
            if (pers.getType() == "Passenger") {
                Passenger pass = (Passenger) list.get(i);
                if (pass.getMethod()) buffer = "Credit Card";
                else buffer = "Cash";
                System.out.printf("| %-15s%-15s%-14s%-15s%-20s%-16s|\n", "Driver", pass.getName(), pass.getBalance(), "-", "-", buffer);
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------\n");
    }

    //boolean ascending_compare(P)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Object> list = new ArrayList<Object>();
        list.add(new Passenger("Anna", 6000, true));
        list.add(new Passenger("Irina", 6000, false));
        list.add(new Driver("Ivan", 7000, 10, 600));
        list.add(new Driver("Sergey", 6000, 7, 350));
        list.add(new Passenger("Yuriy", 8000, true));
        list.add(new Driver("Ivan", 7000, 10, 560));
        list.add(new Passenger("Kirill", 6000, false));
        list.add(new Person("Kirill", 8000));
        list.add(new Passenger("Yuriy", 5000, true));
        list.add(new Person("Andrey", 5000));
        list.add(new Driver("Sergey", 6000, 7, 350));
        list.add(new Person("Elena", 5500));
        list.add(new Passenger("Anna", 6000, false));
        list.add(new Person("Andrey", 3000));
        list.add(new Driver("Dmitriy", 1000, 5, 120));
        list.add(new Driver("Sergey", 4000, 7, 340));

        list_output(list);
    }
}
