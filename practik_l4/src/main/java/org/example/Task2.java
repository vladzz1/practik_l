package org.example;
import java.util.*;

public class Task2 {
    private final Map<String, List<String>> dictionary = new TreeMap<>();
    private final Map<String, Integer> requestCounter = new HashMap<>();

    public void run(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Додати\n2. Пошук\n3. Редагувати\n4. Топ популярності\n0. Вихід");
            int action = scanner.nextInt();
            scanner.nextLine();
            if (action == 0) break;

            if (action == 1) {
                System.out.print("Слово: ");
                String word = scanner.nextLine().toLowerCase();
                System.out.print("Переклад: ");
                dictionary.computeIfAbsent(word, k -> new ArrayList<>()).add(scanner.nextLine());
                requestCounter.putIfAbsent(word, 0);
            }
            else if (action == 2) {
                System.out.print("Слово: ");
                String w = scanner.nextLine().toLowerCase();
                if (dictionary.containsKey(w)) {
                    requestCounter.put(w, requestCounter.get(w) + 1);
                    System.out.println(dictionary.get(w));
                }
            }
            else if (action == 4) {
                List<Map.Entry<String, Integer>> list = new ArrayList<>(requestCounter.entrySet());
                list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
                list.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
            }
        }
    }
}
