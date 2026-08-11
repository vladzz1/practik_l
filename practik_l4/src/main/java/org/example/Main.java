package org.example;
import org.example.utils.HibernateHelper;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("OOP Java 3");
        //try {
        //    System.out.println("Підлкючення до БД");
        //    var session = HibernateHelper.getSession();
        //    // ....
        //    HibernateHelper.shutDown();
        //}
        //catch (Exception x) {
        //    System.out.println("Щось пішло не так" + x.getMessage());
        //}

        //завдання 1

        Array array = new Array();
        Scanner scanner = new Scanner(System.in);
        System.out.print("введіть перше число: ");
        int char1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть друге число: ");
        int char2 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть третє число: ");
        int char3 = scanner.nextInt();
        scanner.nextLine();
        array.add(char1);
        array.add(char2);
        array.add(char3);
        System.out.println(array);
        Random rand = new Random();
        for (short i = 0; i < 7; i++) {
            array.add(rand.nextInt(10 - -10 + 1) + -10);
        }
        System.out.println(array);
        System.out.println("максимальне: " + array.max());
        System.out.println("мінімальне: " + array.min());
        System.out.println("середнє арефметичне: " + array.avg());
        array.sortAsc();
        System.out.println(array);
        array.sortDesc();
        System.out.println(array);
        array.sortAsc();
        System.out.println("пошук 2: індекс " + array.find(2));
        array.change(3, 6);
        System.out.println(array);

        //завдання 2

        Matrix matrix = new Matrix(5);
        int[] arr = new int[5];
        System.out.print("введіть перше число: ");
        arr[0] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть друге число: ");
        arr[1] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть третє число: ");
        arr[2] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть четверте число: ");
        arr[3] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("введіть п'яте число: ");
        arr[4] = scanner.nextInt();
        scanner.nextLine();
        matrix.addOneLine(arr);
        for (short i = 0; i < 5; i++) {
            arr[i] = rand.nextInt(10 - -10 + 1) + -10;
        }
        matrix.addOneLine(arr);
        System.out.println(matrix);

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        int[][] m3 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = rand.nextInt(10 - -10 + 1) + -10;
                m2[i][j] = rand.nextInt(10 - -10 + 1) + -10;

                int randomValue;
                do {
                    randomValue = rand.nextInt(10 - -10 + 1) + -10;
                }
                while (randomValue == 0);
                    m3[i][j] = randomValue;
            }
        }

        System.out.println("----------------");
        System.out.println("додавання: " + Arrays.deepToString(matrix.addition(m1, m2)));
        System.out.println("віднімання: " + Arrays.deepToString(matrix.addition(m1, m2)));
        System.out.println("множення: " + Arrays.deepToString(matrix.addition(m1, m2)));
        System.out.println("ділення: " + Arrays.deepToString(matrix.addition(m1, m3)));
        System.out.println("----------------");
        System.out.println("мінімум: " + matrix.min(m1));
        System.out.println("максимум: " + matrix.max(m1));
        System.out.println("середнє арефметичне: " + matrix.avg(m1));
    }
}