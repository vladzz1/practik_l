package org.example.services;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.example.config.RolesConstants;
import org.example.dtos.account.RegisterDto;
import org.example.entities.RoleEntity;
import org.example.entities.UserEntity;
import org.example.repositories.IRoleRepository;
import org.example.repositories.IUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor //Для DI - Dependency Injection щоб усе працювало як сало
public class AccountService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String uploadDir = "uploads/";

    public UserEntity register(RegisterDto dto, HttpServletRequest request) {
        UserEntity user = new UserEntity();
        if (dto.getImageFile() == null || dto.getImageFile().isEmpty()) {
            throw new IllegalArgumentException("Photo upload is required");
        }
        if(userRepository.findByUsername(dto.getUsername()).isPresent())
            throw new IllegalArgumentException("Username already exists");
        if(userRepository.findByEmail(dto.getEmail()).isPresent())
            throw new IllegalArgumentException("Email already exists");
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            throw new IllegalArgumentException("Passwords do not match");
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        try {
            String savedFileName = saveAndResizeAvatar(dto.getImageFile());
            user.setImage(savedFileName);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to save profile image", e);
        }

        RoleEntity roleUser = roleRepository.findByName(RolesConstants.UserRole).orElseThrow(()->new RuntimeException("User role not found"));
        user.getRoles().add(roleUser);

        UserEntity saveUser = userRepository.save(user);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(saveUser, null, saveUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        request.getSession(true).setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return saveUser;
    }

    private String saveAndResizeAvatar(MultipartFile file) throws IOException {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String uniqueFileName = UUID.randomUUID() + ".jpg";
        File destination = Paths.get(uploadDir, uniqueFileName).toFile();

        Thumbnails.of(file.getInputStream()).size(150, 150).crop(net.coobird.thumbnailator.geometry.Positions.CENTER).outputFormat("jpg").toFile(destination);

        return uniqueFileName;
    }
}