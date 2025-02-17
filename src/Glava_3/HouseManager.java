package Glava_3;
import java.util.ArrayList;
import java.util.List;




public class HouseManager {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House(1, 101, 56.5, 3, 2, "Главная ул.", "Кирпичный", 10));
        houses.add(new House(2, 102, 78.0, 5, 3, "Зеленая ул.", "Панельный", 15));
        houses.add(new House(3, 103, 45.0, 2, 1, "Березовая ул.", "Деревянный", 5));
        houses.add(new House(4, 104, 90.0, 7, 4, "Главная ул.", "Кирпичный", 12));

        System.out.println("Квартиры с 3 комнатами:");
        filterByRooms(houses, 3);

        System.out.println("Квартиры с 2 комнатами на этажах 2-5:");
        filterByRoomsAndFloor(houses, 2, 2, 5);

        System.out.println("Квартиры с площадью больше 50 м²:");
        filterByArea(houses, 50);
    }

    public static void filterByRooms(List<House> houses, int rooms) {
        for (House house : houses) {
            if (house.getRooms() == rooms) {
                System.out.println(house);
            }
        }
    }

    public static void filterByRoomsAndFloor(List<House> houses, int rooms, int minFloor, int maxFloor) {
        for (House house : houses) {
            if (house.getRooms() == rooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                System.out.println(house);
            }
        }
    }

    public static void filterByArea(List<House> houses, double minArea) {
        for (House house : houses) {
            if (house.getArea() > minArea) {
                System.out.println(house);
            }
        }
    }
}
