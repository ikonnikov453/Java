package Glava_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class informationTheDeveloper {

    public static void main(String[] args) {

        infoTheDeveloper();

    }

    //ГЛАВА 1
    private static void  infoTheDeveloper(){
        String developerLastName = "Иконников";

        LocalDateTime receivedDateTime = LocalDateTime.of(2025, 2, 04, 14, 45);

        LocalDateTime submissionDateTime = LocalDateTime.of(2025, 2, 17, 18, 00);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Фамилия разработчика: " + developerLastName);
        System.out.println("Дата и время получения задания: " + receivedDateTime.format(formatter));
        System.out.println("Дата и время сдачи задания: " + submissionDateTime.format(formatter));
    }
}