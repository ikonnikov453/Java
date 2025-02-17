package Glava_3;

public class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private String buildingType;
    private int yearsInUse;

    // Конструкторы
    public House(int id, int apartmentNumber, double area, int floor, int rooms, String street, String buildingType, int yearsInUse) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = buildingType;
        this.yearsInUse = yearsInUse;
    }

    public House(int id, int apartmentNumber, double area, int rooms, String street) {
        this(id, apartmentNumber, area, 0, rooms, street, "Неизвестно", 0);
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public int getApartmentNumber() { return apartmentNumber; }
    public double getArea() { return area; }
    public int getFloor() { return floor; }
    public int getRooms() { return rooms; }
    public String getStreet() { return street; }
    public String getBuildingType() { return buildingType; }
    public int getYearsInUse() { return yearsInUse; }

    public void setId(int id) { this.id = id; }
    public void setApartmentNumber(int apartmentNumber) { this.apartmentNumber = apartmentNumber; }
    public void setArea(double area) { this.area = area; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public void setStreet(String street) { this.street = street; }
    public void setBuildingType(String buildingType) { this.buildingType = buildingType; }
    public void setYearsInUse(int yearsInUse) { this.yearsInUse = yearsInUse; }

    @Override
    public String toString() {
        return "Квартира{" +
                "ID=" + id +
                ", Номер квартиры=" + apartmentNumber +
                ", Площадь=" + area + " м²" +
                ", Этаж=" + floor +
                ", Количество комнат=" + rooms +
                ", Улица='" + street + '\'' +
                ", Тип здания='" + buildingType + '\'' +
                ", Срок эксплуатации=" + yearsInUse + " лет" +
                '}';
    }
}

