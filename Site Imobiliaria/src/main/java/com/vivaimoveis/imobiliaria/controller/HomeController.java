package com.vivaimoveis.imobiliaria.controller;

import com.vivaimoveis.imobiliaria.model.Imovel;
import com.vivaimoveis.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping("/") // Mapeia a URL raiz
    public String index(Model model) {
        List<Imovel> imoveis = imovelRepository.findAll();

        if (imoveis != null && !imoveis.isEmpty()) {
            Random rand = new Random();
            Imovel imovelAleatorio = imoveis.get(rand.nextInt(imoveis.size()));
            model.addAttribute("imovelAleatorio", imovelAleatorio); // Passa o imóvel aleatório para o template
        } else {
            model.addAttribute("imovelAleatorio", null);
        }

        return "index"; // Retorna a página index.html
    }
}
