package Glava_10;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        List<String> targetWords = Arrays.asList("Java", "программист", "ВСГУТУ");


        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCountMap = new HashMap<>();


        System.out.println("Введите строки (для окончания ввода введите пустую строку):");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] words = line.split("\\s+");

            for (String word : words) {
                word = word.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");

                if (targetWords.contains(word)) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        if (wordCountMap.isEmpty()) {
            System.out.println("Не найдено ни одного слова из списка.");
        } else {
            // Сортировка по частоте
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            System.out.println("Слова в порядке возрастания частоты:");
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
