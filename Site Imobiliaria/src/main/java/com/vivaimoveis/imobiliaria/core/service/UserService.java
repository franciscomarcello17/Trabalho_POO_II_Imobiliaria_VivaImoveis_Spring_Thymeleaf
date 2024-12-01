package com.vivaimoveis.imobiliaria.core.service;

import com.vivaimoveis.imobiliaria.core.entity.User;
import com.vivaimoveis.imobiliaria.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {

    private final String UPLOAD_DIR = "uploads/"; // Diretório para armazenar imagens

    @Autowired
    private UserRepository userRepository; // Usando o repositório UserRepository

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(User user, MultipartFile profilePicture) {
        // Se houver uma foto de perfil, salvamos ela
        if (!profilePicture.isEmpty()) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + profilePicture.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR, fileName);
                Files.createDirectories(filePath.getParent()); // Cria o diretório, se necessário
                profilePicture.transferTo(filePath); // Salva o arquivo de imagem

                // A URL da imagem é salva no banco de dados
                user.setAvatarUrl(filePath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Criptografa a senha antes de salvar
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user); // Salva o usuário no banco de dados
    }
}
