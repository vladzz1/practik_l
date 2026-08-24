package org.example.config;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.example.entities.RoleEntity;
import org.example.entities.UserEntity;
import org.example.repositories.IRoleRepository;
import org.example.repositories.IUserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserSeeder implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final Faker faker = new Faker();

    //public UserSeeder(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
    //    this.userRepository = userRepository;
    //    this.passwordEncoder = passwordEncoder;
    //}

    @Override
    public void run(String @NonNull ... args) throws Exception {
        seedRoles();
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

    private void seedRoles() {
        List<String> roles = RolesConstants.Roles;

        for (String roleName : roles) {
            boolean exists = roleRepository.findByName(roleName).isPresent();
            if (!exists) {
                RoleEntity role = new RoleEntity();
                role.setName(roleName);
                roleRepository.save(role);
                System.out.println("Додано роль: " + roleName);
            }
            else {
                System.out.println("Роль вже існує: " + roleName);
            }
        }
    }
}
