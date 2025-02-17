package Glava_2;

import java.time.LocalDateTime;

public class IncreasingNumberFinder {

    public static boolean isStrictlyIncreasing(int number) {
        String numStr = String.valueOf(number);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) <= numStr.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {134, 245, 123, 789, 321, 4567, 987};

        int result = -1;
        for (int num : numbers) {
            if (isStrictlyIncreasing(num)) {
                result = num;
                break;
            }
        }

        if (result != -1) {
            System.out.println("Первое число с цифрами в строгом порядке возрастания: " + result);
        } else {
            System.out.println("Такого числа нет в массиве.");
        }

        System.out.println("Разработчик: Иконников Д.А.");
        System.out.println("Дата и время получения задания: " + LocalDateTime.of(2025, 2, 04, 14, 45));
        System.out.println("Дата и время сдачи задания: " + LocalDateTime.now());
    }
}
