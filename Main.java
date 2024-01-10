import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void list_output(List<Person> list) {
        int n = list.size(); String buffer;
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-20s |\n", "Тип", "Имя", "Баланс", "Опыт", "Заказы", "Метод оплаты");
        System.out.println("--------------------------------------------------------------------------------------------------");
        int i;
        Person pers;
        for (i = 0; i < n; i++) {
            pers = (Person) list.get(i);
            if (pers.getType() == "Person") {
                System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Человек", pers.getName(), pers.getBalance(), "-", "-", "-");
            }
            if (pers.getType() == "Driver") {
                Driver driver = (Driver) list.get(i);
                System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Водитель", driver.getName(), driver.getBalance(), driver.getExperience(), driver.getOrderAmount(), "-");
            }
            if (pers.getType() == "Passenger") {
                Passenger pass = (Passenger) list.get(i);
                if (pass.getMethod()) buffer = "Банковская карта";
                else buffer = "Наличные";
                System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Пассажир", pass.getName(), pass.getBalance(), "-", "-", buffer);
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------\n");
    }

    public static void search(List<Person> list, Person element) {
        int n = list.size(); int i, count = 0;
        String element_type = element.getType();
        String list_type, buffer = ""; boolean flag = true;
        System.out.print("Результат поиска: ");
        for (i = 0; i < n; i++)
        {
            flag = true;
            list_type = list.get(i).getType();
            if (element_type == list_type)
            {
                if (element.getName() != "")
                {
                    flag = (element.getName() == list.get(i).getName()) && (element.getBalance() == list.get(i).getBalance());
                }
                else
                {
                    flag = element.getBalance() == list.get(i).getBalance();
                }

                if (element_type == "Driver")
                {
                    Driver list_driver = (Driver)list.get(i);
                    Driver element_driver = (Driver)element;
                    flag = flag && (list_driver.getExperience() == element_driver.getExperience() && list_driver.getOrderAmount() == element_driver.getOrderAmount());
                }
                if (element_type == "Passenger")
                {
                    Passenger list_pass = (Passenger)list.get(i);
                    Passenger element_pass = (Passenger)element;
                    flag = flag && (list_pass.getMethod() == element_pass.getMethod());
                }
                if (flag)
                {
                    count++;
                    if (count == 1) 
                    {
                        System.out.println("\n--------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-20s |\n", "Тип", "Имя", "Баланс", "Опыт", "Заказы", "Метод оплаты");
                        System.out.println("--------------------------------------------------------------------------------------------------");
                    }
                    if (list.get(i).getType() == "Person") {
                        System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Человек", list.get(i).getName(), list.get(i).getBalance(), "-", "-", "-");
                    }
                    if (list.get(i).getType() == "Driver") {
                        Driver driver = (Driver) list.get(i);
                        System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Водитель", driver.getName(), driver.getBalance(), driver.getExperience(), driver.getOrderAmount(), "-");
                    }
                    if (list.get(i).getType() == "Passenger") {
                        Passenger pass = (Passenger) list.get(i);
                        if (pass.getMethod()) buffer = "Банковская карта";
                        else buffer = "Наличные";
                        System.out.printf("| %-15s%-15s%-14s%-15s%-15s%-21s|\n", "Пассажир", pass.getName(), pass.getBalance(), "-", "-", buffer);
                    }
                }
            }
        }
        if (count > 0)
        {
            System.out.println("--------------------------------------------------------------------------------------------------\n");
        }
        else
        {
            System.out.println("совпадения не найдены\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("ТЕСТЫ:");
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList<Person>();
        list.add(new Passenger("Анна", 6000, true));
        list.add(new Passenger("Ирина", 6000, false));
        list.add(new Driver("Иван", 7000, 10, 600));
        list.add(new Driver("Сергей", 6000, 7, 350));
        list.add(new Passenger("Юрий", 8000, true));
        list.add(new Driver("Иван", 7000, 10, 560));
        list.add(new Passenger("Кирилл", 6000, false));
        list.add(new Person("Кирилл", 8000));
        list.add(new Passenger("Юрий", 5000, true));
        list.add(new Person("Андрей", 5000));
        list.add(new Driver("Сергей", 6000, 7, 350));
        list.add(new Person("Елена", 5500));
        list.add(new Passenger("Анна", 6000, false));
        list.add(new Person("Андрей", 3000));
        list.add(new Driver("Дмитрий", 1000, 5, 120));
        list.add(new Driver("Сергей", 4000, 7, 340));

        list_output(list);

        // Сортировка по возрастанию
        Collections.sort(list, new Comparator<Person>() 
        {
            public int compare(Person first, Person second) 
            {
                int flag;
                flag = first.getType().compareTo(second.getType());
                if (flag == 0) 
                {
                    flag = first.getName().compareTo(second.getName());
                    if (flag == 0) 
                    {
                        flag = first.getBalance() - second.getBalance();
                        if (flag == 0)
                        {
                            if (first.getType() == "Driver") // Водитель - Водитель
                            {
                                Driver driver_first = (Driver)first;
                                Driver driver_second = (Driver)second;
                                flag = driver_first.getExperience() - driver_second.getExperience();
                                if (flag == 0)
                                {
                                    flag = driver_first.getOrderAmount() - driver_second.getOrderAmount();
                                }
                            }
                            else if (first.getType() == "Passenger") // Пассажир - Пассажир
                            {
                                Passenger pass_first = (Passenger)first;
                                Passenger pass_second = (Passenger)second;
                                flag = Boolean.compare(pass_first.getMethod(), pass_second.getMethod());
                            }
                        }
                    }
                }
                return flag;
            }
        });
        System.out.println("Сортировка по возрастанию:");
        list_output(list);

        // Сортировка по убыванию
        Collections.reverse(list);
        System.out.println("Сортировка по убыванию:");
        list_output(list);

        // Поиск 1
        Passenger search1 = new Passenger(6000);
        Person person = (Person)search1;
        search(list, person);

        // Поиск 2
        Driver search2 = new Driver("Сергей", 6000, 7, 350);
        person = (Person)search2;
        search(list, person);

        // Поиск 3
        Person search3 = new Person("Кирилл", 8000);
        search(list, search3);

        // Поиск 4
        Person search4 = new Person(100000);
        search(list, search4);
    }
}
