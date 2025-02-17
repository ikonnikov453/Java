package Glava_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RealNumbers {


    public static void  operationsNumbers(){
        String fileName = "numbers.txt";
        List<Double> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] parts = line.split("\\s");
                if (parts.length != 2){
                    System.out.println("Не правильный формат строки: " + line);
                    continue;
                }
                String str_number = parts[0];
                String str_locale = parts[1];
                try {
                    Locale locale = Locale.forLanguageTag(str_locale);
                    NumberFormat format = NumberFormat.getInstance(locale);
                    Number number = format.parse(str_number);
                    numbers.add(number.doubleValue());
                } catch (ParseException e) {
                    System.out.println("Не удалось распознать число в строке!");
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла");
        }

        if (numbers.isEmpty()){
            System.out.println("Нет корректных чисел");
        } else  {
            double sum = 0;
            for (double num : numbers){
                sum +=num;
            }
            double average = sum / numbers.size();

            System.out.println("Сумма: " + sum);
            System.out.println("Среднее: " + average);
        }
    }
}
