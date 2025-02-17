package Glava_8;

public class TextManipulator {
    public static void main(String[] args) {
        // Пример 1: Удаление символа
        String text1 = "abcabcabc";
        char symbol1 = 'a';
        int k1 = 3;
        int flag1 = 0;
        text1 = manipulateText(text1, symbol1, k1, flag1);
        System.out.println("Результат (удаление): " + text1);

        // Пример 2: Вставка символа
        String text2 = "abcabcabc";
        char symbol2 = 'k';
        int k2 = 3;
        int flag2 = 1;
        text2 = manipulateText(text2, symbol2, k2, flag2);
        System.out.println("Результат (вставка): " + text2);
    }

    public static String manipulateText(String text, char symbol, int k, int flag) {
        if (flag == 0) {
            return text.replaceAll(String.valueOf(symbol), "");
        } else if (flag == 1) {
            if (k >= 0 && k < text.length()) {
                return new StringBuilder(text).insert(k, symbol).toString();
            } else {
                System.out.println("Неверная позиция для вставки.");
                return text;
            }
        }
        return text;
    }
}
