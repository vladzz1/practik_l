package org.example;
import java.util.*;

public class Task3 {
    static class Fine {
        String type;
        float amount;
        Fine(String type, float amount) { this.type = type; this.amount = amount; }
        public String toString() { return type + " - " + amount; }
    }

    static class Person {
        String name, city;
        List<Fine> fines = new ArrayList<>();
        Person(String name, String city) { this.name = name; this.city = city; }
    }

    private final Map<String, Person> db = new HashMap<>();

    public void run(Scanner scanner) {
        while (true) {
            System.out.println("1. Додати людину\n2. Додати штраф\n3. Друк бази\n0. Вихід");
            int action = scanner.nextInt();
            scanner.nextLine();
            if (action == 0) { break; }
            else if (action == 1) {
                System.out.print("Код: ");
                String code = scanner.nextLine();
                System.out.print("Ім'я: ");
                String name = scanner.nextLine();
                System.out.print("Місто: ");
                String city = scanner.nextLine();
                db.put(code, new Person(name, city));
            }
            else if (action == 2) {
                System.out.print("Код: ");
                String code = scanner.nextLine();
                if (db.containsKey(code)) {
                    System.out.print("Тип: ");
                    String type = scanner.nextLine();
                    System.out.print("Сума: ");
                    float sum = scanner.nextFloat();
                    db.get(code).fines.add(new Fine(type, sum));
                }
            }
            else if (action == 3) {
                db.forEach((k, v) -> System.out.println(k + " " + v.name + " " + v.fines));
            }
        }
    }
}
