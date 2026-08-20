package org.example.config;
import net.datafaker.Faker;
import org.example.entities.UserEntity;
import org.example.repositories.IUserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Faker faker = new Faker();

    public UserSeeder(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        if (userRepository.count() == 0) {
            List<UserEntity> users = new ArrayList<>();

            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123")); // Хешуємо пароль!
            admin.setImage("https://dicebear.com");
            users.add(admin);

            for (int i = 0; i < 2; i++) {
                UserEntity user = new UserEntity();

                String username = faker.internet().username();
                while (userRepository.existsByUsername(username)) {
                    username = faker.internet().username();
                }

                user.setUsername(username);
                user.setEmail(faker.internet().emailAddress(username));
                user.setPassword(passwordEncoder.encode("password123"));

                user.setImage("https://dicebear.com" + username);

                user.setResetPasswordToken(null);

                users.add(user);
            }

            userRepository.saveAll(users);
            System.out.println("✅ Успішно створено 3 тестових користувачів.");
        }
        else {
            System.out.println("ℹ️ База даних вже містить користувачів. Сідер пропущено.");
        }
    }
}
