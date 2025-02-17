package Glava_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TransformedException {

    public static void exception(){
        try {
            readFile("example.txt");
            checkNumber(99);
        } catch (IllegalArgumentException e){
            System.out.println("Некорректные данные: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа была закрыта!");
        }
    }

    public static void  readFile(String fileName){
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("Файл не найден: " + fileName);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            if (line == null || line.isEmpty()){
                throw  new IllegalArgumentException("Файл пуст или содержит некорректные данные");
            }
            System.out.println("Содержимое файла: " + line);
        } catch (IOException e){
            throw new IllegalArgumentException("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void checkNumber(int number){
        int max_number = 100;
        if (number > max_number){
            throw new IllegalArgumentException("Число " + number + " превышает предела " + max_number);
        }
    }
}
