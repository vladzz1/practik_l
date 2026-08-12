package org.example;
import net.datafaker.Faker;
import org.example.entities.ProductEntity;
import org.example.entities.ProductPhotoEntity;
import org.example.entities.UserEntity;
import org.example.utils.HibernateHelper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.example.entities.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {
    // Папка для зображень всередині проєкту
    private static final Path IMAGES_DIR = Paths.get("images", "products");
    public static void main(String[] args) {
        //System.out.println("OOP Java 3");
        try {
            System.out.println("Підлкючення до БД");
            var session = HibernateHelper.getSession();
            seedCategories(session);
            seedProductsWithPhotos(session);
            seedUsers(session);
            // ....
            HibernateHelper.shutDown();
        }
        catch (Exception x) {
            System.out.println("Щось пішло не так" + x.getMessage());
        }

        //завдання 1

        //Array array = new Array();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("введіть перше число: ");
        //int char1 = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть друге число: ");
        //int char2 = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть третє число: ");
        //int char3 = scanner.nextInt();
        //scanner.nextLine();
        //array.add(char1);
        //array.add(char2);
        //array.add(char3);
        //System.out.println(array);
        //Random rand = new Random();
        //for (short i = 0; i < 7; i++) {
        //    array.add(rand.nextInt(10 - -10 + 1) + -10);
        //}
        //System.out.println(array);
        //System.out.println("максимальне: " + array.max());
        //System.out.println("мінімальне: " + array.min());
        //System.out.println("середнє арефметичне: " + array.avg());
        //array.sortAsc();
        //System.out.println(array);
        //array.sortDesc();
        //System.out.println(array);
        //array.sortAsc();
        //System.out.println("пошук 2: індекс " + array.find(2));
        //array.change(3, 6);
        //System.out.println(array);

        //завдання 2

        //Matrix matrix = new Matrix(5);
        //int[] arr = new int[5];
        //System.out.print("введіть перше число: ");
        //arr[0] = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть друге число: ");
        //arr[1] = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть третє число: ");
        //arr[2] = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть четверте число: ");
        //arr[3] = scanner.nextInt();
        //scanner.nextLine();
        //System.out.print("введіть п'яте число: ");
        //arr[4] = scanner.nextInt();
        //scanner.nextLine();
        //matrix.addOneLine(arr);
        //for (short i = 0; i < 5; i++) {
        //    arr[i] = rand.nextInt(10 - -10 + 1) + -10;
        //}
        //matrix.addOneLine(arr);
        //System.out.println(matrix);
//
        //int[][] m1 = new int[3][3];
        //int[][] m2 = new int[3][3];
        //int[][] m3 = new int[3][3];
//
        //for (int i = 0; i < 3; i++) {
        //    for (int j = 0; j < 3; j++) {
        //        m1[i][j] = rand.nextInt(10 - -10 + 1) + -10;
        //        m2[i][j] = rand.nextInt(10 - -10 + 1) + -10;
//
        //        int randomValue;
        //        do {
        //            randomValue = rand.nextInt(10 - -10 + 1) + -10;
        //        }
        //        while (randomValue == 0);
        //            m3[i][j] = randomValue;
        //    }
        //}
//
        //System.out.println("----------------");
        //System.out.println("додавання: " + Arrays.deepToString(matrix.addition(m1, m2)));
        //System.out.println("віднімання: " + Arrays.deepToString(matrix.addition(m1, m2)));
        //System.out.println("множення: " + Arrays.deepToString(matrix.addition(m1, m2)));
        //System.out.println("ділення: " + Arrays.deepToString(matrix.addition(m1, m3)));
        //System.out.println("----------------");
        //System.out.println("мінімум: " + matrix.min(m1));
        //System.out.println("максимум: " + matrix.max(m1));
        //System.out.println("середнє арефметичне: " + matrix.avg(m1));
    }

    private static void seedCategories(Session session) {
        Random random = new Random(12345);
        Faker faker = new Faker(random);

        List<String> categoryNames = List.of(
                "Електроніка", "Одяг та взуття", "Дім і сад",
                "Спорт та відпочинок", "Краса та здоров'я",
                "Книги", "Іграшки", "Автотовари", "Продукти харчування"
        );

        Transaction transaction = session.beginTransaction();

        for (String name : categoryNames) {
            Long count = session.createQuery(
                            "select count(c) from CategoryEntity c where c.name = :name", Long.class)
                    .setParameter("name", name)
                    .uniqueResult();

            if (count == 0) {
                CategoryEntity category = new CategoryEntity();
                category.setName(name);
                category.setDescription(faker.lorem().sentence(10));
                session.persist(category);
            }
        }

        transaction.commit();
        System.out.println("Категорії перевірені/додані");
    }

    private static void seedProductsWithPhotos(Session session) throws IOException {
        Random random = new Random(54321); // окремий seed для продуктів
        Faker faker = new Faker(random);

        // Створюємо папку для зображень, якщо її немає
        Files.createDirectories(IMAGES_DIR);

        // Забираємо всі наявні категорії з БД
        Query<CategoryEntity> query = session.createQuery(
                "from CategoryEntity", CategoryEntity.class);
        List<CategoryEntity> categories = query.list();

        if (categories.isEmpty()) {
            System.out.println("Немає категорій у БД, продукти не будуть створені");
            return;
        }

        Transaction transaction = session.beginTransaction();

        int productCounter = 1;

        for (CategoryEntity category : categories) {
            int productsPerCategory = 5; // скільки товарів на категорію

            for (int i = 0; i < productsPerCategory; i++) {
                ProductEntity product = new ProductEntity();
                product.setName(faker.commerce().productName());
                product.setDescription(faker.lorem().sentence(15));
                product.setPrice(BigDecimal.valueOf(
                                faker.number().randomDouble(2, 50, 5000))
                        .setScale(2, RoundingMode.HALF_UP));
                product.setQuantityInStock(faker.number().numberBetween(0, 200));
                product.setCategory(category);

                session.persist(product); // потрібно для отримання id перед фото

                // Генеруємо 1-3 фото на товар
                int photosCount = faker.number().numberBetween(1, 4);
                for (int p = 0; p < photosCount; p++) {
                    String fileName = "product_" + productCounter + "_" + (p + 1) + ".jpg";
                    Path localPath = IMAGES_DIR.resolve(fileName);

                    // Використовуємо picsum.photos із фіксованим seed -> завжди однакові картинки
                    String seedValue = "product" + productCounter + "-" + p;
                    String imageUrl = "https://picsum.photos/seed/" + seedValue + "/400/400";

                    downloadImage(imageUrl, localPath);

                    ProductPhotoEntity photo = new ProductPhotoEntity();
                    photo.setUrl(localPath.toString().replace("\\", "/")); // зберігаємо шлях у БД
                    photo.setIsMain(p == 0);
                    photo.setProduct(product);

                    session.persist(photo);
                }

                productCounter++;
            }
        }

        transaction.commit();
        System.out.println("Продукти та фото успішно згенеровані: " + (productCounter - 1));
    }

    /**
     * Скачує зображення за URL і зберігає локально
     */
    private static void downloadImage(String imageUrl, Path destination) {
        try (InputStream in = URI.create(imageUrl).toURL().openStream()) {
            Files.copy(in, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Скачано: " + destination.getFileName());
        }
        catch (IOException e) {
            System.out.println("Не вдалося скачати " + imageUrl + ": " + e.getMessage());
        }
    }

    private static void seedUsers(Session session) {
        Random random = new Random(99999); // окремий seed для користувачів
        Faker faker = new Faker(random);

        int usersToCreate = 20;
        int createdCount = 0;

        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < usersToCreate; i++) {
            String username = faker.name().username(); // напр. john.doe
            String email = faker.internet().emailAddress();

            // Перевірка на унікальність у БД (username і email мають бути unique)
            Long existing = session.createQuery(
                            "select count(u) from UserEntity u where u.username = :username or u.email = :email",
                            Long.class)
                    .setParameter("username", username)
                    .setParameter("email", email)
                    .uniqueResult();

            if (existing > 0) {
                continue; // пропускаємо дублікат, не рахуємо у createdCount
            }

            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setEmail(email);
            // У реальному проєкті пароль треба хешувати (BCrypt тощо),
            // тут для seed-даних просто фейкове значення
            user.setPassword("123456");
            user.setPhone(faker.phoneNumber().phoneNumber());

            // Випадкова дата реєстрації за останні 2 роки, детермінована seed'ом
            LocalDateTime registrationDate = faker.timeAndDate()
                    .past(730, java.util.concurrent.TimeUnit.DAYS)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            user.setRegistrationDate(registrationDate);

            session.persist(user);
            createdCount++;
        }

        transaction.commit();
        System.out.println("Користувачі успішно згенеровані: " + createdCount);
    }
}