package Glava_7;

public class Main {


    @FunctionalInterface
    public interface DiscriminantCalculator {
        double calculate(double a, double b, double c);
    }

    public static void main(String[] args) {
        // Лямбда-выражение для вычисления дискриминанта
        DiscriminantCalculator discriminantCalculator = (a, b, c) -> b * b - 4 * a * c;

        // Пример использования
        double a = 1.0, b = -3.0, c = 2.0;
        double discriminant = discriminantCalculator.calculate(a, b, c);

        System.out.println("Дискриминант: " + discriminant);
    }
}
