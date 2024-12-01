package com.vivaimoveis.imobiliaria.controller;

import com.vivaimoveis.imobiliaria.core.entity.User;
import com.vivaimoveis.imobiliaria.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CadastroController {

    @Autowired
    private UserService userService;

    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Cria um objeto de User no modelo
        return "cadastro"; // Retorna para o template de cadastro
    }

    @PostMapping("/cadastro")
    public String processRegistration(
            @ModelAttribute User user,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("profilePicture") MultipartFile profilePicture,
            Model model) {

        // Verifica se as senhas coincidem
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "As senhas não coincidem.");
            return "cadastro"; // Se não coincidirem, retorna ao formulário com erro
        }

        // Verifica se o usuário é maior de idade
        if (!user.isAdult()) {
            model.addAttribute("error", "Você precisa ter pelo menos 18 anos para se cadastrar.");
            return "cadastro";
        }

        user.setPassword(password); // Define a senha do usuário

        try {
            // Chama o serviço para registrar o usuário
            userService.registerUser(user, profilePicture);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // Mensagem de erro se a idade for inválida
            return "cadastro"; // Retorna o erro para o template
        }

        return "redirect:/login"; // Após o sucesso, redireciona para a página de login
    }
}