package org.example;
import org.example.utils.HibernateHelper;

public class Main {
    public static void main(String[] args) {
        //System.out.println("OOP Java 3");
        try {
            System.out.println("Підлкючення до БД");
            var session = HibernateHelper.getSession();
            // ....
            HibernateHelper.shutDown();
        }
        catch (Exception x) {
            System.out.println("Щось пішло не так" + x.getMessage());
        }
    }
}