public class Order {
    private static int min_payment = 200;
    private int status;

    public Order(boolean rate, boolean congestion, Passenger passenger, Driver driver, Car car) {
        System.out.println("ЗАКАЗ");
        int payment;
        payment = calculate_payment(rate, congestion);

        this.status = 0;
        if (passenger.getBalance() < payment) {
            System.out.println("На балансе пассажира недостаточно средств! (Сумма поездки: " + payment + ")");
        } else {
            if (car.fuel.getCapacity() == false) {
                System.out.println("У выбранной машины не заполнен топливный бак!");
            } else {
                if (rate) { // Класс поездки - Комфорт
                    if (driver.getExperience() < 10 || driver.getOrderAmount() < 30) {
                        System.out.println("У выбранного водителя недостаточно лет опыта или завершённых заказов для выполнения заказа уровня Комфорт!");
                    } else {
                        if (car.getRate() == false) {
                            System.out.println("Выбранный автомобиль недостаточно высокого класса для выполнения заказа уровня Комфорт!");
                        } else {
                            this.status = 1;
                        }
                    }
                } else { // Класс поездки - Эконом
                    this.status = 1;
                }
            }
        }
        if (this.status == 1) {
            passenger.takePayment(payment);
            driver.givePayment(payment);
            driver.increaseOrderAmount();
            car.fuel.empty();
            System.out.println("Заказ выполнен успешно! Информация на момент завершения заказа:\n");
            System.out.println("Класс поездки: " + (rate ? "Комфорт" : "Эконом"));
            System.out.println("Загруженность дорог: " + (congestion ? "Есть" : "Нет"));
            System.out.println("Стоимость поездки: " + payment + "\n");
            System.out.println(passenger);
            System.out.println(driver);
            System.out.println(car);
        }
    }

    static void increase_payment() {
        min_payment += 300;
    }

    public int calculate_payment(boolean rate, boolean congestion) {
        int price;
        price = min_payment;
        if (rate) {
            price += 300; // Класс поездки - Комфорт
        }
        if (congestion) {
            price *= 2; // Если дороги загруженны
        }
        return price;
    }
}
