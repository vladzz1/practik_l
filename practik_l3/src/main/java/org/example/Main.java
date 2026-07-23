package org.example;
import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int exit(Scanner scanner) {
        System.out.println("ви впевнені, що хочете вийти?\n1. так\n2. ні");
        String operation = scanner.nextLine();
        switch (operation) {
            case "1":
                return 0;
            case "2":
                return 1;
            default:
                exit(scanner);
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("натисніть c щоб пропустити: ");
        String c = scanner.nextLine();
        if (!Objects.equals(c, "c")) {
            try(var session = HibernateHelper.getSession()) {
                while (true) {
                    session.beginTransaction();
                    System.out.println("++Слава Україні++");
                    System.out.println("Нехай буде hibernate");
                    System.out.print("1. Get\n2. GetById\n3. Post\n4. Put\n5. Delete\n0. Exit\nВкажіть номер операції: ");
                    String operation = scanner.nextLine();
                    switch (operation) {
                        case "0":
                            int result = exit(scanner);
                            if (result == 0)
                                return;
                            else
                                break;
                        case "1":
                            var list = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
                            for (var item : list)
                                System.out.printf("%d\t%s\n", item.getId(), item.getName());
                            session.getTransaction().commit();
                            break;
                        case "2":
                            System.out.print("введіть id: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            var list2 = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
                            for (var item : list2) {
                                if (item.getId() == id) {
                                    System.out.printf("%d\t%s\n", item.getId(), item.getName());
                                    break;
                                }
                            }
                            session.getTransaction().commit();
                            break;
                        case "3":
                            System.out.print("введіть назву категорії: ");
                            String categoryName = scanner.nextLine();
                            CategoryEntity category = new CategoryEntity(categoryName);
                            session.persist(category);
                            break;
                        case "4":
                            System.out.print("введіть id категорії яку потрібно змінити: ");
                            int categoryId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("введіть нову назву категорії: ");
                            String categoryName2 = scanner.nextLine();
                            var list3 = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
                            for (var item : list3) {
                                if (item.getId() == categoryId) {
                                    item.setName(categoryName2);
                                    break;
                                }
                            }
                            session.getTransaction().commit();
                            break;
                        case "5":
                            System.out.print("введіть id категорії яку потрібно видалити: ");
                            int categoryId2 = scanner.nextInt();
                            scanner.nextLine();
                            var list4 = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
                            for (var item : list4) {
                                if (item.getId() == categoryId2) {
                                    session.remove(item);
                                    break;
                                }
                            }
                            session.getTransaction().commit();
                            break;
                        default:
                            break;
                    }
                }
            }
            catch (Exception x) {
                System.out.println("Помилка " + x.getMessage());
            }
        }
        //завдання 1

        Builder builder = new Builder("Ігор", "None", 21, LocalDateTime.of(2004, 2, 15, 19, 23), 3);
        Sailor sailor = new Sailor("Іван", "None", 26, LocalDateTime.of(1999, 6, 3, 2, 12), 5673);
        Pilot pilot = new Pilot("Сергій", "None", 31, LocalDateTime.of(1994, 5, 24, 1, 17), 71);
        System.out.println(builder);
        System.out.println(sailor);
        System.out.println(pilot);

        //завдання 2

        Tiger tiger = new Tiger("Тигрик", 42.3F, 3, 71);
        Crocodile crocodile = new Crocodile("Крокодильчик", 62.1F, 3, 2);
        Kangaroo kangaroo = new Kangaroo("Великий", 64.0F, 4, 6.0F);
        System.out.println(tiger);
        System.out.println(crocodile);
        System.out.println(kangaroo);

        //завдання 3

        Product product = new Product(5, "None");
        System.out.println(product);
        product.lowerThePriceOfTheProductByDollars(2);
        System.out.println(product);

        //завдання 4

        Kettle kettle = new Kettle();
        Microwave microwave = new Microwave();
        Car car = new Car();
        Steamship steamship = new Steamship();
        System.out.print("---kettle---\nsound: ");
        kettle.sound();
        System.out.print("show: ");
        kettle.show();
        System.out.print("desc: ");
        kettle.desc();
        System.out.print("---microwave---\nsound: ");
        microwave.sound();
        System.out.print("show: ");
        microwave.show();
        System.out.print("desc: ");
        microwave.desc();
        System.out.print("---car---\nsound: ");
        car.sound();
        System.out.print("show: ");
        car.show();
        System.out.print("desc: ");
        car.desc();
        System.out.print("---steamship---\nsound: ");
        steamship.sound();
        System.out.print("show: ");
        steamship.show();
        System.out.print("desc: ");
        steamship.desc();

        //завдання 5

        Violin violin = new Violin();
        Trombone trombone = new Trombone();
        Ukulele ukulele = new Ukulele();
        Cello cello = new Cello();
        System.out.print("---violin---\nsound: ");
        violin.sound();
        System.out.print("show: ");
        violin.show();
        System.out.print("desc: ");
        violin.desc();
        System.out.print("history: ");
        violin.history();
        System.out.print("---trombone---\nsound: ");
        trombone.sound();
        System.out.print("show: ");
        trombone.show();
        System.out.print("desc: ");
        trombone.desc();
        System.out.print("history: ");
        trombone.history();
        System.out.print("---ukulele---\nsound: ");
        ukulele.sound();
        System.out.print("show: ");
        ukulele.show();
        System.out.print("desc: ");
        ukulele.desc();
        System.out.print("history: ");
        ukulele.history();
        System.out.print("---cello---\nsound: ");
        cello.sound();
        System.out.print("show: ");
        cello.show();
        System.out.print("desc: ");
        cello.desc();
        System.out.print("history: ");
        cello.history();

        //завдання 6

        int[] arr = new int[10];
        Random rand = new Random();
        for (short i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(10 - -10 + 1) + -10;
        }
        Array array = new Array(arr);
        System.out.println("максимальне: " + array.max());
        System.out.println("мінімальне: " + array.min());
        System.out.println("середнє арифметичне: " + array.avg());

        //завдання 7

        System.out.println(array);
        array.sortAsc();
        System.out.println(array);
        array.sortDesc();
        System.out.println(array);
    }
}