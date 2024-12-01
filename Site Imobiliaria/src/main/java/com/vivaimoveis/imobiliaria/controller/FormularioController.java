package com.vivaimoveis.imobiliaria.controller;

import com.vivaimoveis.imobiliaria.core.entity.Formulario;
import com.vivaimoveis.imobiliaria.core.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@Controller
@RequestMapping("/contato")
public class FormularioController {

    @Autowired
    private FormularioRepository formularioRepository;

    // Caminho para salvar os arquivos
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/enviar")
    public String enviarFormulario(@ModelAttribute Formulario formulario,
                                   @RequestParam("attachment") MultipartFile attachment) {
        try {
            // Processar o arquivo (caso o usuário tenha anexado algum)
            if (!attachment.isEmpty()) {
                // Gerar o nome do arquivo (por exemplo, usando o nome original ou um nome único)
                String fileName = System.currentTimeMillis() + "_" + attachment.getOriginalFilename();

                // Salvar o arquivo fisicamente no diretório 'uploads'
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.createDirectories(path.getParent());  // Garante que o diretório exista
                Files.write(path, attachment.getBytes());  // Salva o arquivo no diretório

                // Defina o nome do arquivo no formulário (ou o caminho)
                formulario.setAnexo(fileName);
            }

            // Salvar o formulário no banco de dados
            formularioRepository.save(formulario);

            // Redirecionar para uma página de sucesso ou confirmação
            return "contato/sucesso";
        } catch (IOException e) {
            e.printStackTrace();
            return "contato/erro";
        }
    }
}
