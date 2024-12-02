package com.vivaimoveis.imobiliaria.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@ControllerAdvice
public class GlobalModelAttributes {

    private static final String AVATAR_PATH = "/images/avatars/";

    @ModelAttribute
    public void addAuthenticationToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Adiciona a autenticação ao modelo global
        model.addAttribute("authentication", authentication);

        // Verifica se o usuário está autenticado
        if (authentication != null && !authentication.getName().equals("anonymousUser")) {
            // Verifica se o arquivo do avatar existe
            String username = authentication.getName();
            Path avatarPath = Paths.get(AVATAR_PATH + username + ".jpg");
            boolean avatarExists = Files.exists(avatarPath);

            // Adiciona o status do avatar ao modelo global
            model.addAttribute("avatarExists", avatarExists);
        }

        System.out.println("Authentication: " + authentication);  // Verifique o estado da autenticação
        System.out.println("========================================================================");  // Verifique o estado da autenticação
    }
}
