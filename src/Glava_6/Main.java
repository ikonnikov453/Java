package Glava_6;

import java.util.Scanner;

public class Main {

    // Статусы вагонов
    public enum VagonStatus {
        ЗАГРУЗКА, РАЗГРУЗКА, В_ПУТИ, В_РЕМОНТЕ, ГОТОВ_К_ОТПРАВКЕ, ТРЕБУЕТ_РЕМОНТА
    }

    // Интерфейс для всех вагонов
    public interface IVagon {
        String getRegistrationNumber();
        void setRegistrationNumber(String registrationNumber);

        String getDestination();
        void setDestination(String destination);

        String getOwner();
        void setOwner(String owner);

        VagonStatus getStatus();
        void setStatus(VagonStatus status);

        double getWeight();
        void setWeight(double weight);

        void sendToDestination();
        void service();
        void repair();
        void load();
        void unload();
        double getCargoValue();
        void displayInfo();
    }

    // Базовый класс для всех вагонов
    public static class Vagon implements IVagon {
        private String registrationNumber;
        private String destination;
        private String owner;
        private VagonStatus status;
        private double weight;

        public Vagon(String registrationNumber, String destination, String owner, VagonStatus status, double weight) {
            this.registrationNumber = registrationNumber;
            this.destination = destination;
            this.owner = owner;
            this.status = status;
            this.weight = weight;
        }

        @Override
        public String getRegistrationNumber() {
            return registrationNumber;
        }

        @Override
        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        @Override
        public String getDestination() {
            return destination;
        }

        @Override
        public void setDestination(String destination) {
            this.destination = destination;
        }

        @Override
        public String getOwner() {
            return owner;
        }

        @Override
        public void setOwner(String owner) {
            this.owner = owner;
        }

        @Override
        public VagonStatus getStatus() {
            return status;
        }

        @Override
        public void setStatus(VagonStatus status) {
            this.status = status;
        }

        @Override
        public double getWeight() {
            return weight;
        }

        @Override
        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public void sendToDestination() {
            System.out.println("Вагон отправляется в пункт назначения: " + destination);
        }

        @Override
        public void service() {
            System.out.println("Вагон проходит обслуживание.");
        }

        @Override
        public void repair() {
            System.out.println("Вагон на ремонте.");
        }

        @Override
        public void load() {
            System.out.println("Вагон загружается.");
        }

        @Override
        public void unload() {
            System.out.println("Вагон разгружается.");
        }

        @Override
        public double getCargoValue() {
            return 0; // Для базового вагона нет груза
        }

        @Override
        public void displayInfo() {
            System.out.println("Вагон: " + registrationNumber + " [Владелец: " + owner + ", Статус: " + status + ", Масса: " + weight + "]");
        }
    }

    // Класс для грузового вагона
    public static class CargoVagon extends Vagon {
        private double cargoValue;

        public CargoVagon(String registrationNumber, String destination, String owner, VagonStatus status, double weight, double cargoValue) {
            super(registrationNumber, destination, owner, status, weight);
            this.cargoValue = cargoValue;
        }

        @Override
        public double getCargoValue() {
            return cargoValue;
        }

        @Override
        public void load() {
            System.out.println("Груз загружается в грузовой вагон.");
        }

        @Override
        public void unload() {
            System.out.println("Груз разгружается из грузового вагона.");
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Стоимость груза: " + cargoValue);
        }
    }

    // Класс для пассажирского вагона
    public static class PassengerVagon extends Vagon {
        private int passengerCapacity;
        private int currentPassengers;

        public PassengerVagon(String registrationNumber, String destination, String owner, VagonStatus status, double weight, int passengerCapacity) {
            super(registrationNumber, destination, owner, status, weight);
            this.passengerCapacity = passengerCapacity;
            this.currentPassengers = 0;
        }

        public void boardPassenger(int count) {
            if (currentPassengers + count <= passengerCapacity) {
                currentPassengers += count;
                System.out.println(count + " пассажиров сели.");
            } else {
                System.out.println("Недостаточно места для " + count + " пассажиров.");
            }
        }

        public void disembarkPassenger(int count) {
            if (currentPassengers - count >= 0) {
                currentPassengers -= count;
                System.out.println(count + " пассажиров вышли.");
            } else {
                System.out.println("Недостаточно пассажиров для высадки.");
            }
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Вместимость пассажиров: " + passengerCapacity + ", Текущие пассажиры: " + currentPassengers);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример создания грузового вагона
        System.out.println("Введите номер регистрационного вагона:");
        String registrationNumber = scanner.nextLine();

        System.out.println("Введите пункт назначения:");
        String destination = scanner.nextLine();

        System.out.println("Введите владельца вагона:");
        String owner = scanner.nextLine();

        System.out.println("Введите статус вагона (ЗАГРУЗКА, РАЗГРУЗКА, В_ПУТИ, В_РЕМОНТЕ, ГОТОВ_К_ОТПРАВКЕ, ТРЕБУЕТ_РЕМОНТА):");
        VagonStatus status = VagonStatus.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Введите массу вагона:");
        double weight = scanner.nextDouble();

        System.out.println("Введите стоимость груза:");
        double cargoValue = scanner.nextDouble();

        CargoVagon cargoVagon = new CargoVagon(registrationNumber, destination, owner, status, weight, cargoValue);

        // Пример создания пассажирского вагона
        scanner.nextLine();  // Очистить буфер ввода после nextDouble()

        System.out.println("\nВведите номер регистрационного пассажирского вагона:");
        registrationNumber = scanner.nextLine();

        System.out.println("Введите пункт назначения:");
        destination = scanner.nextLine();

        System.out.println("Введите владельца вагона:");
        owner = scanner.nextLine();

        System.out.println("Введите статус вагона (ЗАГРУЗКА, РАЗГРУЗКА, В_ПУТИ, В_РЕМОНТЕ, ГОТОВ_К_ОТПРАВКЕ, ТРЕБУЕТ_РЕМОНТА):");
        status = VagonStatus.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Введите массу вагона:");
        weight = scanner.nextDouble();

        System.out.println("Введите вместимость пассажиров:");
        int passengerCapacity = scanner.nextInt();

        PassengerVagon passengerVagon = new PassengerVagon(registrationNumber, destination, owner, status, weight, passengerCapacity);

        // Выводим информацию о вагонах
        System.out.println("\nИнформация о грузовом вагоне:");
        cargoVagon.displayInfo();
        cargoVagon.load();
        cargoVagon.unload();

        System.out.println("\nИнформация о пассажирском вагоне:");
        passengerVagon.displayInfo();
        passengerVagon.boardPassenger(50);
        passengerVagon.disembarkPassenger(20);
    }
}
